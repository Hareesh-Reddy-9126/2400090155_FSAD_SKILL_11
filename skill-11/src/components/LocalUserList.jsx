import React, { useState, useEffect } from "react";

function LocalUserList() {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    fetch("/users.json")
      .then((res) => {
        if (!res.ok) throw new Error("Failed to fetch local users");
        return res.json();
      })
      .then((data) => {
        setUsers(data);
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message);
        setLoading(false);
      });
  }, []);

  if (loading) return <div className="loader">Loading local users...</div>;
  if (error) return <div className="error">{error}</div>;

  return (
    <div>
      <h3>Local Users</h3>
      <table className="user-table">
        <thead>
          <tr>
            <th>Name</th><th>Email</th><th>Phone</th>
          </tr>
        </thead>
        <tbody>
          {users.map(u => (
            <tr key={u.id}>
              <td>{u.name}</td>
              <td>{u.email}</td>
              <td>{u.phone}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default LocalUserList;
