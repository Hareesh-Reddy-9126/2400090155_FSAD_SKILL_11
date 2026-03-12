import React, { useState, useEffect } from "react";
import axios from "axios";

function AddStudent({ editingStudent, onSuccess }) {
  const [form, setForm] = useState({ name: "", email: "", course: "" });
  const [editId, setEditId] = useState(null);

  useEffect(() => {
    if (editingStudent) {
      setForm({
        name: editingStudent.name,
        email: editingStudent.email,
        course: editingStudent.course
      });
      setEditId(editingStudent.id);
    } else {
      setForm({ name: "", email: "", course: "" });
      setEditId(null);
    }
  }, [editingStudent]);

  const handleChange = e => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = e => {
    e.preventDefault();
    if (editId) {
      axios.put(`http://localhost:8085/students/${editId}`, form)
        .then(() => {
          setForm({ name: "", email: "", course: "" });
          setEditId(null);
          onSuccess();
        });
    } else {
      axios.post("http://localhost:8085/students", form)
        .then(() => {
          setForm({ name: "", email: "", course: "" });
          onSuccess();
        });
    }
  };

  return (
    <div>
      <h3>{editId ? "Update Student" : "Add Student"}</h3>
      <form className="student-form" onSubmit={handleSubmit}>
        <input
          name="name"
          value={form.name}
          onChange={handleChange}
          placeholder="Name"
          required
        />
        <input
          name="email"
          value={form.email}
          onChange={handleChange}
          placeholder="Email"
          required
        />
        <input
          name="course"
          value={form.course}
          onChange={handleChange}
          placeholder="Course"
          required
        />
        <button type="submit">{editId ? "Update" : "Add"}</button>
        {editId && <button type="button" onClick={() => {
          setForm({ name: "", email: "", course: "" });
          setEditId(null);
          onSuccess();
        }}>Cancel</button>}
      </form>
    </div>
  );
}

export default AddStudent;
