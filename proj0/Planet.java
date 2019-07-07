public class Planet
{
	public double xxPos, yyPos, xxVel, yyVel, mass;
	public String imgFileName;
	private double G = 6.67e-11;
	//constructor 1;
	public Planet(double xP, double yP, double xV, 
		          double yV, double m, String img){
		xxPos = xP; 
		yyPos = yP; 
		xxVel = xV;
		yyVel = yV;
		mass  = m;
		imgFileName = img;
	}
	//constructor 2;
	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}
	//计算两个planet间的distance;
	public double calcDistance(Planet p){
		double d, r;
		d = (this.xxPos - p.xxPos)*(this.xxPos - p.xxPos) + 
			(this.yyPos - p.yyPos)*(this.yyPos - p.yyPos);
		r = Math.sqrt(d);
		return r;
	}
	//计算两个planet之间的万有引力；
	public double calcForceExertedBy(Planet p){
		return G * this.mass * p.mass / Math.pow(this.calcDistance(p), 2);
	}
	//计算this_lanet在x轴所受到的万有引力，有符号；
	public double calcForceExertedByX(Planet p){
		double fx;
		fx = this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
		return fx;
	}

	//the f of this planet in the direction of y;
	public double calcForceExertedByY(Planet p){
		double fy;
		fy = this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
		return fy;
	}
	
	//计算this_planet在x轴所受到的所有星球的引力合力
	public double calcNetForceExertedByX(Planet[] allPlanets){
		double fx;
		double fx_net = 0;
		int i;
		for(i = 0; i < allPlanets.length; i++){
			if(allPlanets[i].equals(this)){
				continue;
			}
			fx = this.calcForceExertedByX(allPlanets[i]);
			fx_net = fx_net + fx;
		}
		return fx_net;
	}
	//计算this_planet在y轴所受到的所有星球的引力合力
	public double calcNetForceExertedByY(Planet[] allPlanets){
		double fy;
		double fy_net = 0;
		int i;
		for(i = 0; i < allPlanets.length; i++){
			if(allPlanets[i].equals(this)){
				continue;
			}
			fy = this.calcForceExertedByY(allPlanets[i]);
			fy_net = fy_net + fy;
		}
		return fy_net;
	}
	//update velocity and position after forcing this planet in a period;
	public void update(double dt, double fX, double fY){
		double a_x = fX / this.mass; //calculate acceleration
		double a_y = fY / this.mass;
		this.xxVel = this.xxVel + dt * a_x; // calculate new v;
		this.yyVel = this.yyVel + dt * a_y;
		this.xxPos = this.xxPos + dt * this.xxVel; // calculate new pos;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}
	//draw a planet;
	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
	}
	

}
