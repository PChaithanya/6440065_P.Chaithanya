const events = [
  { name: "Neighborhood Cleanup", date: "2025-06-05" },
  { name: "Food Truck Festival", date: "2025-06-12" },
  { name: "Outdoor Movie Night", date: "2025-06-18" }
];

window.onload = () => {
  const container = document.getElementById("events-container");
  const select = document.querySelector("select[name='event']");

  // Load and display events
  events.forEach(event => {
    const card = document.createElement("div");
    card.className = "event-card";
    card.innerHTML = `<h3>${event.name}</h3><p>Date: ${event.date}</p>`;
    container.appendChild(card);

    const option = document.createElement("option");
    option.value = event.name;
    option.textContent = event.name;
    select.appendChild(option);
  });

  // Handle form submission
  document.getElementById("registrationForm").addEventListener("submit", e => {
    e.preventDefault();
    const form = e.target;
    const name = form.name.value.trim();
    const email = form.email.value.trim();
    const selectedEvent = form.event.value;

    if (name && email && selectedEvent) {
      document.getElementById("form-message").textContent = `Thanks ${name}, you’re registered for ${selectedEvent}!`;
      form.reset();
    } else {
      document.getElementById("form-message").textContent = "Please complete all fields.";
    }
  });
};
