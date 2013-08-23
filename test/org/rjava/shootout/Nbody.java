package org.rjava.shootout;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class Nbody {
    public static final double PI = 3.141592653589793;
    public static final double days_per_year = 365.24;
    public static final double solar_mass = 4 * PI * PI;
    
    static class Planet {
        double x, y, z;
        double vx, vy, vz;
        double mass;
    }
    
    public static void advance(Planet[] bodies, double dt) {
        int i, j;
        int nbodies = bodies.length;
        
        for (i = 0; i < nbodies; i++) {
            Planet b = bodies[i];
            for (j = i + 1; j < nbodies; j++) {
                Planet b2 = bodies[j];
                double dx = b.x - b2.x;
                double dy = b.y - b2.y;
                double dz = b.z - b2.z;
                double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
                double mag = dt / (distance * distance * distance);
                b.vx -= dx * b2.mass * mag;
                b.vy -= dy * b2.mass * mag;
                b.vz -= dz * b2.mass * mag;
                b2.vx += dx * b.mass * mag;
                b2.vy += dy * b.mass * mag;
                b2.vz += dz * b.mass * mag;
            }
        }
        
        for (i = 0; i < nbodies; i++) {
            Planet b = bodies[i];
            b.x += dt * b.vx;
            b.y += dt * b.vy;
            b.z += dt * b.vz;
        }           
    }
    
    public static double energy(Planet[] bodies) {
        double e;
        int i, j;
        int nbodies = bodies.length;
        
        e = 0.0;
        for (i = 0; i < nbodies; i++) {
            Planet b = bodies[i];
            e += 0.5 * b.mass * (b.vx * b.vx + b.vy * b.vy + b.vz * b.vz);
            for (j = i + 1; j < nbodies; j++) {
                Planet b2 = bodies[j];
                double dx = b.x - b2.x;
                double dy = b.y - b2.y;
                double dz = b.z - b2.z;
                double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
                e -= (b.mass * b2.mass) / distance;
            }                
        }
        
        return e;
    }
    
    public static void offset_momentum(Planet[] bodies) {
        double px = 0.0, py = 0.0, pz = 0.0;
        int nbodies = bodies.length;
        int i;
        for (i = 0; i < nbodies; i++) {
            px += bodies[i].vx * bodies[i].mass;
            py += bodies[i].vy * bodies[i].mass;
            pz += bodies[i].vz * bodies[i].mass;
        }
        bodies[0].vx = - px / solar_mass;
        bodies[0].vy = - py / solar_mass;
        bodies[0].vz = - pz / solar_mass;
    }
    
    static final Planet[] bodies = new Planet[5];
    static {
        Planet sun = new Planet();
        sun.x = 0;
        sun.y = 0;
        sun.z = 0;
        sun.vx = 0;
        sun.vy = 0;
        sun.vz = 0;
        sun.mass = solar_mass;
        bodies[0] = sun;
        
        Planet jupiter = new Planet();
        jupiter.x = 4.84143144246472090e+00;
        jupiter.y = -1.16032004402742839e+00;
        jupiter.z = -1.03622044471123109e-01;
        jupiter.vx = 1.66007664274403694e-03 * days_per_year;
        jupiter.vy = 7.69901118419740425e-03 * days_per_year;
        jupiter.vz = -6.90460016972063023e-05 * days_per_year;
        jupiter.mass = 9.54791938424326609e-04 * solar_mass;
        bodies[1] = jupiter;
        
        Planet saturn = new Planet();
        saturn.x = 8.34336671824457987e+00;
        saturn.y = 4.12479856412430479e+00;
        saturn.z = -4.03523417114321381e-01;
        saturn.vx = -2.76742510726862411e-03 * days_per_year;
        saturn.vy = 4.99852801234917238e-03 * days_per_year;
        saturn.vz = 2.30417297573763929e-05 * days_per_year;
        saturn.mass = 2.85885980666130812e-04 * solar_mass;
        bodies[2] = saturn;
        
        Planet uranus = new Planet();
        uranus.x = 1.28943695621391310e+01;
        uranus.y = -1.51111514016986312e+01;
        uranus.z = -2.23307578892655734e-01;
        uranus.vx = 2.96460137564761618e-03 * days_per_year;
        uranus.vy = 2.37847173959480950e-03 * days_per_year;
        uranus.vz = -2.96589568540237556e-05 * days_per_year;
        uranus.mass = 4.36624404335156298e-05 * solar_mass;
        bodies[3] = uranus;
        
        Planet neptune = new Planet();
        neptune.x = 1.53796971148509165e+01;
        neptune.y = -2.59193146099879641e+01;
        neptune.z = 1.79258772950371181e-01;
        neptune.vx = 2.68067772490389322e-03 * days_per_year;
        neptune.vy = 1.62824170038242295e-03 * days_per_year;
        neptune.vz = -9.51592254519715870e-05 * days_per_year;
        neptune.mass = 5.15138902046611451e-05 * solar_mass;
        bodies[4] = neptune;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int i;
        
        offset_momentum(bodies);
        System.out.println(energy(bodies));
        for (i = 1; i <= n; i++)
            advance(bodies, 0.01);
        System.out.println(energy(bodies));
    }

}
