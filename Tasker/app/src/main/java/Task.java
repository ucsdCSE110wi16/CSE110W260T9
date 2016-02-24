/**
 * Created by Kris on 2/23/2016.
 */
public class Task {
    String name;
    String description;
    int worth;
    String createdBy;
    String location;

    CommentThread comments;

    Task(String n,String desc,int w,String creater, String loc) {
      name = n;
      description = desc;
      worth = w;
      createdBy = creater;
      location = loc;
    }

    //public void commentOn


}
