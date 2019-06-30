public class NBody
{	
	// read the radius of this universe;
	public static double readRadius(String file){
		In in = new In(file);
		int planets_num = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	//read data of planets;
	public static Planet[] readPlanets(String file){
		In in = new In(file);
		int planets_num = in.readInt();
		double radius = in.readDouble();
		// the hardest part is below;
		Planet[] all_planets = new Planet[planets_num]; //all_planets is an array containing all planets;
		for(int i = 0; i < planets_num; i++){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass  = in.readDouble();
			String imgFileName = in.readString();
			//all_planets[i] is an object;
			all_planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}
		return all_planets;
	}
	
	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		// get radius and all planets in this file;
		double radius_of_universe = readRadius(filename);
		Planet[] all_planets = readPlanets(filename);
		//draw background;
		StdDraw.setScale(-radius_of_universe, radius_of_universe);
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");
		//draw all planets;
		for(Planet p : all_planets){
			p.draw();
		}
		// start animation;
		double time = 0;
		//prevent animation flickering;
		StdDraw.enableDoubleBuffering();
		//draw all planets in the universe;
		for(time = 0; time <= T; time += dt){
			double[] xForces = new double[all_planets.length];
			double[] yForces = new double[all_planets.length];
			for(int i = 0; i < all_planets.length; i++){
				//calculate the net force of each planet and store;
				xForces[i] = all_planets[i].calcNetForceExertedByX(all_planets);
				yForces[i] = all_planets[i].calcNetForceExertedByY(all_planets);
			}
			for(int j = 0; j < all_planets.length; j++){
				all_planets[j].update(dt, xForces[j], yForces[j]);
			}
			//draw background;
			StdDraw.picture(0, 0, "images/starfield.jpg");
			//draw all planets;
			for(Planet p : all_planets){
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}
		//print the universe;
		StdOut.printf("%d\n", all_planets.length);
		StdOut.printf("%.2e\n", radius_of_universe);
		for (int i = 0; i < all_planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
			              all_planets[i].xxPos, all_planets[i].yyPos, all_planets[i].xxVel,
			              all_planets[i].yyVel, all_planets[i].mass, all_planets[i].imgFileName);   
			}
	}
}