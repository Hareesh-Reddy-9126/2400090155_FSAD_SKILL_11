import React, { useEffect, useState } from "react";
import axios from "axios";

function StudentList({ onEdit }) {
  const [students, setStudents] = useState([]);

  const fetchStudents = () => {
    axios.get("http://localhost:8085/students")
      .then(res => setStudents(res.data))
      .catch(() => setStudents([]));
  };

  useEffect(() => {
    fetchStudents();
  }, []);

  const handleDelete = (id) => {
    axios.delete(`http://localhost:8085/students/${id}`)
      .then(() => setStudents(students.filter(s => s.id !== id)));
  };

  return (
    <div>
      <h3>Student List</h3>
      <table className="student-table">
        <thead>
          <tr>
            <th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {students.map(student => (
            <tr key={student.id}>
              <td>{student.id}</td>
              <td>{student.name}</td>
              <td>{student.email}</td>
              <td>{student.course}</td>
              <td>
                <button onClick={() => onEdit(student)}>Update</button>
                <button onClick={() => handleDelete(student.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default StudentList;
