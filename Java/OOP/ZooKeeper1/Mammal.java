public class Mammal{
     Integer energyLevel = 100;

     public Integer displayEnergy(){
        System.out.println("Energy Level: "+energyLevel);
        return energyLevel;
     }

     public Integer displayEnergy(int eng){
        energyLevel = eng;
        System.out.println("Energy Level: "+energyLevel);
        return energyLevel;
     }
}