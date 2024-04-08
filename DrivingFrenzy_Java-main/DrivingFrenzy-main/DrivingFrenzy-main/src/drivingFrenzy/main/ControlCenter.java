package drivingFrenzy.main;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import drivingFrenzy.race.Section;
import drivingFrenzy.race.StandardIndoorSection;
import drivingFrenzy.race.Track;
import drivingFrenzy.vehicles.Kart;
import drivingFrenzy.vehicles.Scooter;
import drivingFrenzy.vehicles.Vehicle;

/**
 * @author ismael This is the Control Center. It is the entry point of the
 *         application, where the races are created, vehicles are added...
 */
public class ControlCenter {

	private final static String USAGE = "El programa genera un n�mero aleatorio de veh�culos y secciones de pista y realiza la carrera. \n"
			+ "El programa automaticamente para tras imprimir una l�nea, esperando a que el usuario pulse enter para continuar.";

	/**
	 * @param minSections
	 * @param maxSections
	 * @param minVehicles
	 * @param maxVehicles
	 * @param minVehicleSpeed
	 * @param maxVehicleSpeed
	 * @param minSectionLenght
	 * @param maxSectionLength
	 * @param minSectionSpeed
	 * @param maxSectionSpeed
	 * @throws IOException
	 *
	 * This method creates simple race with StandarIndoorSection sections
	 * and Scooters, with initial random stats
	 */





/*
	private static void simpleRandomRace(int minSections, int maxSections, int minVehicles, int maxVehicles,
			int minVehicleSpeed, int maxVehicleSpeed, int minSectionLenght, int maxSectionLength, int minSectionSpeed,
			int maxSectionSpeed) throws IOException {
		// We will need a variable to return random numbers to generate the initial
		// conditions.
		Random random = new Random();

		// first, we randomly decide on the race conditions.

		int numberOfSections = random.nextInt(minSections, maxSections+1);
		int numberOfVehicles = random.nextInt(minVehicles, maxVehicles+1);

		// next, we create the track.
		Section[] sections = new Section[numberOfSections];

		for (int i = 0; i < numberOfSections; i++) {
			sections[i] = new StandardIndoorSection(random.nextInt(minSectionLenght, maxSectionLength+1),
					"una recta sencilla", random.nextInt(minSectionSpeed, maxSectionSpeed+1));
		}

		Track track = new Track(sections);

		// Next, we create some vehicles
		Vehicle[] vehicles = new Vehicle[numberOfVehicles];

		for (int i = 0; i < numberOfVehicles; i++) {
			vehicles[i] = new Scooter(i, "un conductor an�nimo", 0, random.nextInt(minVehicleSpeed, maxVehicleSpeed),
					"scooter");
		}

		start(track, vehicles);
	}*/

	/**
	 * This method receives a track and a list of cars and it starts a race, showing the results in command line. 
	 * @throws IOException 
	 */


	/*Creamos método defaultRace, version simple del simpleRandomRace pero todo predefinido*/
	/*private static void defaultRace() throws IOException {

		//Creamos las 5 secciones predefinidas de 1000, 2000, 3000, 2000 y 1000 mtrs de length
		Section[] sections = new Section[5];
		sections[0] = new StandardIndoorSection(1000, "Tramo corto", 80);
		sections[1] = new StandardIndoorSection(2000, "Tramo medio", 90);
		sections[2] = new StandardIndoorSection(3000, "Tramo largo", 110);
		sections[3] = new StandardIndoorSection(2000, "Tramo medio", 90);
		sections[4] = new StandardIndoorSection(1000, "Tramo corto", 80);

		//Creamos la track con las secciones definidas
		Track track = new Track(sections);

		//Creamos 3 vehiculos, scooters con sus propias descripciones y conductores
		Vehicle[] scooters = new Vehicle[3];
		scooters[0] = new Scooter(3, "eloy",0, 17,
				"scooter negro");
		scooters[1] = new Scooter(5, "nicolas",0, 21,
				"scooter rojo");
		scooters[2] = new Scooter(19, "isaias",0, 17,
				"scooter azul");

		//run the race
		start(track, scooters);
	}*/

	private static void newRaceKart() throws IOException {
		Section[] sections = new Section[5];
		sections[0] = new StandardIndoorSection(1000, "Tramo corto", 80);
		sections[1] = new StandardIndoorSection(2000, "Tramo medio", 90);
		sections[2] = new StandardIndoorSection(3000, "Tramo largo", 110);
		sections[3] = new StandardIndoorSection(2000, "Tramo medio", 90);
		sections[4] = new StandardIndoorSection(1000, "Tramo corto", 80);

		//Creamos la track con las secciones definidas
		Track track = new Track(sections);

		//Creamos 3 vehiculos, karts con sus propias descripciones y conductores
		Vehicle[] karts = new Vehicle[3];
		karts[0] = new Kart(3, "eloy",0, 90, "kart negro", 0, 45, 0, 90,45);
		karts[1] = new Kart(5, "nicolas",0, 90, "kart rojo", 0, 45, 0, 90,45);
		karts[2] = new Kart(19, "isaias",0, 90, "kart azul", 0, 45, 0, 90,45);
		karts[1].increaseGear();

		//run the race
		start(track, karts);
	}

	private static void start(Track track, Vehicle[] karts) throws IOException {
		// At the end, who won the race? We should re-order the results. TODO.

		// We will track the total time per vehicle in an array matching positions. However, this should be done differently, with proper Java Objects.
		double[] times = new double[karts.length];

		// NOW WE START THE RACE!!!! We have to get the times for each vehicle per
		// section, and then the total time.
		nextComment(
				"Bienvenidos a la carrera simple en l�nea recta indoor. Hoy tenemos algunas scooters tratando de realizar el trayecto lo m�s r�pido posible!");
		nextComment("Comencemos con alguna informaci�n sobre la pista:");
		nextComment(track.getDescription());
		nextComment("Tenemos hoy " + karts.length + " competidores: ");
		for (Vehicle vehicle : karts) {
			nextComment("Con el numero " + vehicle.getNumber() + " tenemos un " + vehicle.getDescription()
					+ " pilotado por " + vehicle.getDriver() + ". Este vehiculo alcanza una velocidad maxima de "
					+ vehicle.getMaxSpeed() + " km/h");
		}
		nextComment("Comienza la carrera!");

		for (int i=0; i<karts.length; i++) {
			Vehicle vehicle = karts[i];
			// for each vehicle, we want to track its total time.
			int currentSectionPosition = 1;
			double totalTime = 0;
			nextComment("El siguiente piloto es " + vehicle.getDriver() + " con el n�mero " + vehicle.getNumber()
					+ ". Se prepara para salir!");
			for (Section section : track.getSections()) {
				nextComment("\tEl siguiente tramo es el n�mero " + currentSectionPosition + ", "
						+ section.getDescription() + " de " + section.getLength()
						+ " metros de longitud, con una velocidad m�xima permitida de "
						+ section.getTheoreticalMaxSpeed() + "km/h");
				// The driver modifies the speed based on the section about to enter
				String action = vehicle.adaptSpeed(section);
				double secondsThisSection = section.getLength() / (vehicle.getCurrentSpeed()*1d/1000*3600);
				nextComment("\t" + action);
				nextComment("\tPasa la secci�n en " + secondsThisSection + " segundos." );
				totalTime += secondsThisSection;
				nextComment("\tSu tiempo total tras el tramo " + currentSectionPosition + " es de " + timeTo2Decimals(totalTime) + " segundos");
				currentSectionPosition++;
			}
			nextComment("\tFinaliza el recorrido! Su tiempo total es de " + timeTo2Decimals(totalTime) + " segundos.");
			times[i] = totalTime;
		}

		nextComment("Y acaba la carrera! Los tiempos de los pilotos son: ");
		for (int i=0; i<karts.length;i++) {
			Vehicle vehicle = karts[i];
				nextComment("\t" + vehicle.getDriver() + " con el n�mero " + vehicle.getNumber() + " ha hecho un tiempo de " + timeTo2Decimals(times[i]) + " segundos.");
		}
	}

	private static String timeTo2Decimals(double time) {
		return 0.01 * Math.round(time*100)+"";
	}


	
	public static void main(String[] args) throws IOException {
		System.out.println(USAGE);
		newRaceKart();
	}

	/*
	 * This method is just used as a convenience method to print a comment and await
	 * for the user to click enter to go to the next comment.
	 */
	private static void nextComment(String comment) throws IOException {
		System.out.println(comment);
//		System.in.read();
	}
}
