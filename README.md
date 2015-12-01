# Subscription
Run main method in subscription.test.Test Class, it will automatically use two threads publishing messages to queue, and one thread subscribe the queue periodically. The subscriber thread will stop re-subscribe once there is no incoming message to the queue.

In MesQue Class, I use two HashMap save message information, one for message detail and another for message publish time. The hashmaps are thread safe because retrieve() message method is synchronized. 

Cancel the annotation in MesQue will print the thread safe count number.
Cancel the annotation in Subscriber will print the message information when resubscribe and get new messages.
