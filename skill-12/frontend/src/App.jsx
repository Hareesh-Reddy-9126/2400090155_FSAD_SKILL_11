import React, { useState } from "react";
import AddStudent from "./components/AddStudent";
import StudentList from "./components/StudentList";
import "./App.css";

function App() {
  const [editingStudent, setEditingStudent] = useState(null);
  const [refresh, setRefresh] = useState(false);

  const handleEdit = student => {
    setEditingStudent(student);
  };

  const handleSuccess = () => {
    setEditingStudent(null);
    setRefresh(r => !r);
  };

  return (
    <div className="container">
      <h2>Skill-12: Full Stack Student CRUD App</h2>
      <AddStudent editingStudent={editingStudent} onSuccess={handleSuccess} />
      <StudentList key={refresh} onEdit={handleEdit} />
    </div>
  );
}

export default App;
