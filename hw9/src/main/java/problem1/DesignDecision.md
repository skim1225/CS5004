# Design Decisions
1. We decided to use the MV* architecture for this assignment to separate the visual
representation of our program output from the logic of the program. This minimizes coupling
as well as makes our code mode modular by encapsulating related behaviors into specialized classes.


2. We chose to use the singleton creation pattern to create the Theater object for our
program because we wanted only one instance of the theater class to exist at this time. This
could prevent concurrency issues as well as issues with users' seat reservations
overlapping due to reserving seats in different Theater objects.