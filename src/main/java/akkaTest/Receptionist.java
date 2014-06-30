package akkaTest;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by dmytro_veres on 30.06.14.
 */
public class Receptionist extends UntypedActor{

    private Queue<ActorRef> visitors;
    private int maxVisitors;

    public Receptionist(int maxVisitors) {
        visitors = new LinkedList<ActorRef>();
        this.maxVisitors = maxVisitors;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Messages.Hello) {
            if (visitors.size() == maxVisitors) {
                getSender().tell(new Messages.BarbershopFull(), getSelf());
            } else {
                visitors.add(getSender());
            }
        } else if (message instanceof Messages.NeedClients) {
            if (visitors.size() == 0) {
                getSender().tell(new Messages.NextClient(null), getSelf());
            } else {
                ActorRef nextVisitor = visitors.remove();
                getSender().tell(new Messages.NextClient(nextVisitor), getSelf());
            }
        }
    }
}
