<!DOCTYPE html>
<html>
<head>
  <title>Event Functions Demo</title>
</head>
<body>
  <h2>Open the browser console to view the output</h2>

  <script>
    // Event store
    const events = [];

    // Function to add a new event
    function addEvent(name, category, seats) {
      const newEvent = { name, category, seats };
      events.push(newEvent);
    }

    // Closure to track total registrations per category
    function createCategoryTracker() {
      const totals = {};
      return function(category) {
        if (!totals[category]) {
          totals[category] = 1;
        } else {
          totals[category]++;
        }
        console.log(`Total registrations in '${category}': ${totals[category]}`);
      };
    }

    const trackRegistration = createCategoryTracker();

    // Register user for an event
    function registerUser(eventName) {
      const event = events.find(e => e.name === eventName);
      if (event && event.seats > 0) {
        event.seats--;
        console.log(`Registered for ${event.name}. Seats left: ${event.seats}`);
        trackRegistration(event.category);
      } else {
        console.log("Registration failed: No seats or event not found.");
      }
    }

    // Higher-order function for filtering
    function filterEventsByCategory(callback) {
      return events.filter(callback);
    }

    // Test setup
    addEvent("Cleanup Drive", "environment", 5);
    addEvent("Music Fest", "entertainment", 3);
    addEvent("Coding Bootcamp", "education", 4);

    console.log("All Events:", events);

    registerUser("Music Fest");
    registerUser("Music Fest");
    registerUser("Music Fest"); // now full
    registerUser("Music Fest"); // should fail

    // Filter dynamically by category
    const eduEvents = filterEventsByCategory(e => e.category === "education");
    console.log("Education Events:", eduEvents);
  </script>
</body>
</html>
