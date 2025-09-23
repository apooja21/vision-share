# Vision Share - Screen Broadcasting using Java RMI  

## 📌 Overview  
This project demonstrates **screen broadcasting over a local network** using **Java RMI (Remote Method Invocation)**.  
The system follows a **client-server architecture**:  
- The **server** captures and broadcasts its screen as video frames.  
- The **clients**, connected to the same network, can view the broadcast by connecting via the server’s IP address.  

This solution eliminates the limitations of projectors in classrooms or meetings by enabling direct screen sharing to multiple computers simultaneously.  

---

## 🎯 Objectives  
- Broadcast one computer’s screen to multiple clients over a LAN.  
- Provide a reliable alternative to projectors for classrooms, labs, and presentations.  
- Enable remote participation in one-way presentation-based sessions.  

---

## ⚙️ Technologies Used  
- **Java RMI** (Remote Method Invocation)  
- **RMI-IIOP** (Java RMI over IIOP for CORBA integration)  
- **RMIIO** (library for streaming large data via RMI)  
- **Eclipse IDE**  
- **Java Development Kit (JDK)**  

---

## 🖥️ Requirements  

### Software  
- JDK 8+  
- Eclipse (or any Java IDE)  
- Libraries: `RMI-IIOP`, `RMIIO`  

### Hardware  
- Windows 7/8/10  
- Intel/AMD x86-64 processor  
- 4–6 GB RAM  

---

## 🔄 Workflow  
1. **Server Initialization** – Starts registry and waits for client connections.  
2. **Client Connection** – Clients enter the server’s IP to connect.  
3. **Broadcasting** – Server captures and streams its screen.  
4. **Viewing** – Clients receive and display the broadcasted screen.  

---

## 📚 References  
- [Java RMI – Oracle Docs](https://docs.oracle.com/javase/tutorial/rmi/overview.html)  
- [Javatpoint RMI Tutorial](https://www.javatpoint.com/RMI)  
- [RMIIO Library](http://openhms.sourceforge.net/rmiio/apidocs/index.html)  
