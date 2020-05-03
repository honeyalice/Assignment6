package Project6;

public class Road implements Comparable<Road>{
   private Town t1, t2;
   private String name;
   private int degrees;

   /**
    * Constructor
    * @param t1 One town on the road
    * @param t2 Another town on the road
    * @param degrees Weight of the edge, i.e., distance from one town to the other
    * @param name Name of the road
    */
   public Road(Town t1, Town t2, int degrees, String name) {
	   this.t1 = t1;
	   this.t2 = t2;
	   this.degrees = degrees;
	   this.name = name;
   }
   
   /**
    * Constructor with weight preset at 1,
    * @param t1 One town on the road
    * @param t2 Another town on the road
    * @param name name of the road
    */
   public Road(Town t1, Town t2, String name) {
	   this.t1 = t1;
	   this.t2 = t2;
	   this.name = name;
	   this.degrees = 1;
	   
   }
   
   /**
    * Return true only if the edge contains the given town
    * @param t a vertex of the graph
    * @return true only if the edge if connected to the given vertex
    */
   public boolean contains(Town t) {
	   return (t1.compareTo(t) == 0 || t2.compareTo(t) == 0);
	   
   }
   
   /**
    * compareTo in interface java.lang.Comparable<Road>
    * @return 0 if the road names are the same, a positive or negative number if the road names are not the same 
    */
   public int compareTo(Road r){
	   if (degrees > r.degrees) {
           return 1;
       }
       if (degrees < r.degrees) {
           return -1;
       }
       return 0;
   }
       
   
   /**
    * Returns true if each of the ends of the road r is the same as the ends of this road. 
    * Remember that a road that goes from point A to point B is the same as a road that goes from point B to point A.
    * @param r road object to compare it to
    */
   @Override
   public boolean equals(Object o) {
	   if (o == this) {
           return true;
       }
       if (o == this) {
           return true;
       }
       if (!(o instanceof Road)) {
           return false;
       }
       Road r = (Road) o;
       return (t1.equals(r.t1) || t1.equals(r.t2))
               && (t2.equals(r.t2) || t2.equals(r.t1));
   }


   
   
   /**
    * return the first town on the road
    * @return  a town on the road
    */
   public Town getT1() {
	   return t1;
   }


   /**
    * set the first town on the road
    * @param t1 a town on the road
    */
   public void setT1(Town t1) {
	   this.t1 = t1;
   }


   /**
    * return another town on the road
    * @return another town on the road
    */
   public Town getT2() {
	   return t2;
   }


   /**
    * set another town on the road
    * @param t2 another town on the road
    */
   public void setT2(Town t2) {
	   this.t2 = t2;
   }


   /**
    * get the road name
    * @return the road name
    */
   public String getName() {
	   return name;
   }

   /**
    * set road name
    * @param name name of the road
    */
   public void setName(String name) {
	   this.name = name;
   }


   /**
    * return the distance of the road
    * @return distance of the road
    */
   public int getDegrees() {
	   return degrees;
   }

   /**
    * set the distance of the road
    * @param degrees distance of the road
    */
   public void setDegrees(int degrees) {
	   this.degrees = degrees;
   }

   
   /**
    * toString method
    */
   @Override
   public String toString()
   {
       return "Road{" + "t1=" + t1 + ", t2=" + t2 + ", Name=" + name + ", Distance=" + degrees + '}';
   }

   
} 