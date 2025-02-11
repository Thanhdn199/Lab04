package hust.soict.dsai.aims.media;



public class DigitalVideoDisc extends Disc implements Playable {

	private static int nbDigitalVideoDiscs = 0;
	
    public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
    	
		super(nbDigitalVideoDiscs++, title, category, cost, 
				length, director);
	}


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DigitalVideoDisc disc = (DigitalVideoDisc) obj;
        
        return this.getTitle().equals(disc.getTitle()) && 
               this.getCategory().equals(disc.getCategory()) && 
               this.getDirector().equals(disc.getDirector()) && 
               this.getCost() == disc.getCost() &&
               this.getLength() == disc.getLength();
    }
    
    
    @Override
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + 
        		this.getCategory() + " - " + getDirector() + " - " + 
        		getLength() + " mins: " + this.getCost() + " $";
    }
    
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    
    @Override
    public int compareTo(Media other) {
        if (other instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) other;
            int titleCompare = this.getTitle().compareTo(dvd.getTitle());
            if (titleCompare != 0) {
                return titleCompare;
            }
            int lengthCompare = Integer.compare(dvd.getLength(), this.getLength());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return Float.compare(dvd.getCost(), this.getCost()); 
        }
        return super.compareTo(other);
    }
}
