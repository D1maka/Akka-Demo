Akka-Demo
=========
В парикмахерской есть зал для стрижки одного клиента и комната  ожидания n клиентов. Клиенты заходят в комнату ожидания по одному, если в ней есть место, либо уходят стричься в другой салон, если все места заняты. После того, как парикмахер заканчивает стрижку, клиент покидает салон и к парикмахеру заходит следующий клиент(если таковой имеется). Клиенты могут по одному заходить в комнату ожидания и также по одному заходить в зал для стрижки (если он свободен), причем эти два события 
являются взаимоисключающими. Если парикмахер видит, что в зале ожидания никого нет, он пересаживается вздремнуть в этом зале. Новый клиент, обнаружив дремлющего парикмахера, будит его, и тот стрижет клиента; в противном случае пришедший клиент должен будет подождать. Воспользуйтесь многопоточностью, чтобы скоординировать действия парикмахера и клиентов.
