import React, { useState } from "react";
import LocalUserList from "./LocalUserList";
import UserList from "./UserList";
import FakePostList from "./FakePostList";

function Dashboard() {
  const [page, setPage] = useState("home");

  return (
    <div className="dashboard-container">
      <h2>SKILL-11: React API Integration</h2>
      <div className="nav-buttons">
        <button onClick={() => setPage("local")}>Local Users</button>
        <button onClick={() => setPage("api")}>Users API</button>
        <button onClick={() => setPage("fake")}>Fake API Posts</button>
      </div>
      <div className="page-content">
        {page === "local" && <LocalUserList />}
        {page === "api" && <UserList />}
        {page === "fake" && <FakePostList />}
        {page === "home" && <div>Select a section above.</div>}
      </div>
    </div>
  );
}

export default Dashboard;
