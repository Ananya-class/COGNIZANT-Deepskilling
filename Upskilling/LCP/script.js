// 1. Basic setup
console.log("Welcome to the Community Portal");
window.onload = () => alert("Page Loaded");

// 2. Data
const events = [
    {name:"Music Fest", date:"2026-06-10", seats:5, category:"Music"},
    {name:"Food Carnival", date:"2026-06-12", seats:0, category:"Food"}
];

// 3. Display events
function displayEvents() {
    const container = document.getElementById("eventContainer");
    container.innerHTML = "";

    events.forEach((e, i) => {
        if (e.seats > 0) {
            let card = document.createElement("div");
            card.className = "eventCard";

            card.innerHTML = `
                <h3>${e.name}</h3>
                <p>Date: ${e.date}</p>
                <p>Seats: ${e.seats}</p>
                <button onclick="register(${i})">Register</button>
            `;

            container.appendChild(card);
        }
    });
}
displayEvents();

// 4. Register user
function register(i) {
    try {
        if (events[i].seats <= 0) throw "No seats";

        events[i].seats--;
        displayEvents();
        alert("Registered!");
    } catch(e) {
        alert(e);
    }
}

// 5. Constructor
function Event(name, date, seats) {
    this.name = name;
    this.date = date;
    this.seats = seats;
}
Event.prototype.checkAvailability = function() {
    return this.seats > 0;
};

// 6. Array methods
let musicEvents = events.filter(e => e.category === "Music");

// 7. Form handling
document.getElementById("form").addEventListener("submit", function(e) {
    e.preventDefault();

    let name = this.elements["name"].value;

    document.getElementById("msg").innerText =
        `Thank you ${name} for registering!`;

    fetch("https://jsonplaceholder.typicode.com/posts", {
        method:"POST",
        body: JSON.stringify({name})
    })
    .then(res => res.json())
    .then(() => console.log("Data sent"))
    .catch(err => console.log(err));
});

// 8. Video event
function videoReady() {
    document.getElementById("videoMsg").innerText = "Video ready";
}

// 9. Leave warning
function confirmLeave() {
    return "Leave page?";
}

// 10. Storage
document.getElementById("eventType").onchange = function() {
    localStorage.setItem("eventType", this.value);
};

// Load saved
window.onload = function() {
    let saved = localStorage.getItem("eventType");
    if (saved) document.getElementById("eventType").value = saved;
};

// Clear storage
function clearStorage() {
    localStorage.clear();
    sessionStorage.clear();
}

// 11. Geolocation
function getLocation() {
    navigator.geolocation.getCurrentPosition(
        pos => {
            document.getElementById("location").innerText =
                pos.coords.latitude + ", " + pos.coords.longitude;
        },
        () => alert("Error"),
        { enableHighAccuracy:true }
    );
}