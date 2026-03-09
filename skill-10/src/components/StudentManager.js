import React, { useState } from "react";
import "../App.css";

const initialStudents = [
  { id: 1, name: "Hareesh", course: "React" },
  { id: 2, name: "Ravi", course: "Java" },
  { id: 3, name: "Anita", course: "Spring Boot" },
  { id: 4, name: "Rahul", course: "NodeJS" },
  { id: 5, name: "Meena", course: "Python" }
];

function StudentManager() {
  const [students, setStudents] = useState(initialStudents);
  const [newStudent, setNewStudent] = useState({ id: "", name: "", course: "" });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewStudent({ ...newStudent, [name]: value });
  };

  const handleAdd = () => {
    if (!newStudent.id || !newStudent.name || !newStudent.course) return;
    setStudents([...students, { ...newStudent, id: Number(newStudent.id) }]);
    setNewStudent({ id: "", name: "", course: "" });
  };

  const handleDelete = (id) => {
    setStudents(students.filter((student) => student.id !== id));
  };

  return (
    <div className="container">
      <h2>Student Manager</h2>
      <div className="input-group">
        <input
          type="number"
          name="id"
          placeholder="Student ID"
          value={newStudent.id}
          onChange={handleChange}
        />
        <input
          type="text"
          name="name"
          placeholder="Name"
          value={newStudent.name}
          onChange={handleChange}
        />
        <input
          type="text"
          name="course"
          placeholder="Course"
          value={newStudent.course}
          onChange={handleChange}
        />
        <button className="add-btn" onClick={handleAdd}>Add Student</button>
      </div>
      {students.length === 0 ? (
        <p className="empty-msg">No students available</p>
      ) : (
        <table className="students-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {students.map((student) => (
              <tr key={student.id}>
                <td>{student.id}</td>
                <td>{student.name}</td>
                <td>{student.course}</td>
                <td>
                  <button className="delete-btn" onClick={() => handleDelete(student.id)}>
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default StudentManager;
