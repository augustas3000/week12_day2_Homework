package behaviours;

import people.Visitor;

public interface ISecurity {
//    method to check persons age;
    boolean isAllowedTo(Visitor visitor);

}
