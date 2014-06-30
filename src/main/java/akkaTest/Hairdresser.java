package akkaTest;

import akka.actor.UntypedActor;
import akka.japi.Procedure;


/**
 * Created by dmytro_veres on 30.06.14.
 */
public class Hairdresser extends UntypedActor{

    public static final int HAIRCUT_DURATION = 500;

    Procedure<Object> sleeping = new Procedure<Object>() {

        @Override
        public void apply(Object param) throws Exception {
            if (param instanceof Messages.WakeUp) {
                getContext().unbecome();
            }
        }
    };

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Messages.NextClient) {
            Messages.NextClient castedMessage = (Messages.NextClient) message;
            if (castedMessage.getClient() == null) {
                getContext().become(sleeping, false);
            } else {
                Thread.sleep(HAIRCUT_DURATION);
                castedMessage.getClient().tell(new Messages.HaircutDone(), getSelf());
            }
        }

    }
}
