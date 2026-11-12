package ec.edu.espoch.leccion4;

import implementaciones.DispositivoDaoMemoria;
import implementaciones.GuiaDaoMemoria;
import implementaciones.TourDaoMemoria;
import Interfaces.DispositivoDao;
import Interfaces.GuiaDao;
import Interfaces.TourDao;
import objetos.DispositivoComunicacion;
import objetos.Guia;
import objetos.Sendero;
import objetos.Tour;
import objetos.TourInterpretativo;
import objetos.TourRegular;
import servicios.AsignacionServicio;
import servicios.CriterioOrdenamiento;
import servicios.OrdenPorDistancia;
import servicios.OrdenPorDuracionTotal;
import servicios.Planificador;
import servicios.ResultadoAsignacion;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leccion4 {
    private static TourDao tourDao = new TourDaoMemoria();
    private static DispositivoDao dispositivoDao = new DispositivoDaoMemoria();
    private static GuiaDao guiaDao = new GuiaDaoMemoria();

    public static void main(String[] args) {
        // Cargar datos de prueba
        Sendero s1 = new Sendero("Sendero del Mono", 2.5, 45);
        Sendero s2 = new Sendero("Sendero del Jaguar", 3.0, 60);
        Sendero s3 = new Sendero("Sendero del Oso", 1.5, 30);

        TourRegular tour1 = new TourRegular("T-001", "Tour Regular Yasuni");
        tour1.agregarSendero(s1);
        tour1.agregarSendero(s2);

        TourInterpretativo tour2 = new TourInterpretativo("T-002", "Tour Interpretativo A", 20);
        tour2.agregarSendero(s2);
        tour2.agregarSendero(s3);

        TourInterpretativo tour3 = new TourInterpretativo("T-003", "Tour Interpretativo B", 30);
        tour3.agregarSendero(s1);
        tour3.agregarSendero(s3);

        tourDao.guardar(tour1);
        tourDao.guardar(tour2);
        tourDao.guardar(tour3);

        DispositivoComunicacion d1 = new DispositivoComunicacion("D-001", "Radio");
        DispositivoComunicacion d2 = new DispositivoComunicacion("D-002", "Telefono satelital");
        dispositivoDao.guardar(d1);
        dispositivoDao.guardar(d2);

        Guia g1 = new Guia("G-001", "Juan Perez");
        Guia g2 = new Guia("G-002", "Maria Gomez");
        guiaDao.guardar(g1);
        guiaDao.guardar(g2);

        List<Tour> tours = tourDao.listarTodos();

        Scanner teclado = new Scanner(System.in);
        probarAsignaciones();
        probarOrdenamiento(tours);
        probarFactorDificultad(teclado);
        teclado.close();
    }

    public static void probarAsignaciones() {
        System.out.println("\n=== Prueba de asignaciones ===");

        AsignacionServicio servicio = new AsignacionServicio(tourDao, dispositivoDao, guiaDao);

        // Asignacion valida
        ResultadoAsignacion r1 = servicio.asignar("T-001", "D-001", "G-001");
        System.out.println(r1.getDetalle());

        // Rechazada por recursos ocupados (D-001 ya no disponible)
        ResultadoAsignacion r2 = servicio.asignar("T-002", "D-001", "G-002");
        System.out.println(r2.getDetalle());

        // Otra valida
        ResultadoAsignacion r3 = servicio.asignar("T-002", "D-002", "G-002");
        System.out.println(r3.getDetalle());
    }

    public static void probarOrdenamiento(List<Tour> tours) {
        System.out.println("\n=== Prueba de ordenamiento ===");
        Planificador planificador = new Planificador(new OrdenPorDistancia());

        List<Tour> porDistancia = planificador.ordenar(tours);
        System.out.println(planificador.getCriterio().descripcion());
        for (Tour t : porDistancia) {
            System.out.println(t.getCodigo() + " - " + t.getNombre() + " (" + t.distanciaTotalKm() + " km)");
        }

        planificador.setCriterio(new OrdenPorDuracionTotal());
        List<Tour> porDuracion = planificador.ordenar(tours);
        System.out.println(planificador.getCriterio().descripcion());
        for (Tour t : porDuracion) {
            System.out.println(t.getCodigo() + " - " + t.getNombre() + " (" + t.duracionTotalMin() + " min)");
        }
    }

    public static void probarFactorDificultad(Scanner t) {
        System.out.println("\n=== Prueba de factor de dificultad ===");
        Tour tour = tourDao.buscarPorId("T-001").get();
        System.out.println("Duracion actual: " + tour.duracionTotalMin() + " min");

        SimuladorDificultad simulador = new SimuladorDificultad(t);
        double nuevo = simulador.simularIncremento(tour.getFactorDificultad());

        System.out.print("¿Acepta el nuevo factor? (s/n): ");
        String respuesta = t.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            tour.aceptarFactor(nuevo);
            tourDao.actualizar(tour);
            System.out.println("Nueva duracion: " + tour.duracionTotalMin() + " min");
        } else {
            System.out.println("Factor no aceptado.");
        }
    }
}