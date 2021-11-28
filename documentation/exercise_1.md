# NVS Exercise 1
### Fischlmayr Jan - 5CHIF

After some Google research i found an article about creating such activities and an documentation, which helped me to complete this exercise.

This project shows how to pass data from one to another activity. This happens at creation time via extras.

All you have to do is create a new activity and add some text views and a button. In order to get some data which I can pass, the user has to enter a text into a EditText field.

In the second activity you just have to look for the value with a specific key, which I set before.

The button on the second activity "returns" you to the first one. This happens through the finish method for activities.
