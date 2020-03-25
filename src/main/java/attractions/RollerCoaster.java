package attractions;

import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ISecurity, IReviewed {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    public boolean isAllowedTo(Visitor visitor) {

        if (visitor.getAge() > 12 & visitor.getHeight() > 1.45) {
            return true;
        } else {
            return false;
        }
    }

}
