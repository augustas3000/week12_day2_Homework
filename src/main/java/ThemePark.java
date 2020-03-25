import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    ArrayList<IReviewed> attractions;
    ArrayList<IReviewed> stalls;
    ArrayList<IReviewed> attractionsAndStalls;


    public ThemePark(ArrayList<IReviewed> attractions, ArrayList<IReviewed> stalls) {
        this.attractions = attractions;
        this.stalls = stalls;

        this.attractionsAndStalls = new ArrayList<IReviewed>();
        this.attractionsAndStalls.addAll(this.stalls);
        this.attractionsAndStalls.addAll(this.attractions);


    }

    public ArrayList<IReviewed> getAllReviewed() {
        return this.attractionsAndStalls;
    }
//
    public void visit(Visitor visitor, Attraction attraction) {
        Attraction found = findAttraction(attraction);

        visitor.addAttractionToVisited(found);
        found.setVisitCount(found.getVisitCount() + 1);
    }

//    helper find attraction

    public Attraction findAttraction(Attraction attraction) {
        Attraction found = null;
        for (int attractionIndex = 0; attractionIndex < this.attractions.size(); attractionIndex++) {
            if (attraction.getName().equals(this.attractions.get(attractionIndex).getName())) {
                found = (Attraction) this.attractions.get(attractionIndex);
            }
        }
        return found;
    }


    public HashMap<String, Integer> review() {
        HashMap<String,Integer> allReviews;
        allReviews = new HashMap<String, Integer>();

        for (int i = 0; i < this.attractionsAndStalls.size(); i++) {

            String attrOrStallName = this.attractionsAndStalls.get(i).getName();
            Integer attrOrStallRating = this.attractionsAndStalls.get(i).getRating();
            allReviews.put(attrOrStallName, attrOrStallRating) ;

        }
        return allReviews;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> allowedThings = new ArrayList<IReviewed>();

        for (int i = 0; i < this.attractionsAndStalls.size(); i++) {

            if (this.attractionsAndStalls.get(i) instanceof ISecurity) {
                boolean answer = ((ISecurity) this.attractionsAndStalls.get(i)).isAllowedTo(visitor);

                if (answer) {
                    allowedThings.add(this.attractionsAndStalls.get(i));
                }

            } else {
                allowedThings.add(this.attractionsAndStalls.get(i));
            }
        }
        return allowedThings;
    }


}
