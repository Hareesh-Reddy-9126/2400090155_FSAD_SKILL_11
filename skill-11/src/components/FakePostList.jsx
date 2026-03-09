import React, { useState, useEffect } from "react";
import axios from "axios";

function FakePostList() {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");
  const [userId, setUserId] = useState("all");

  const fetchPosts = () => {
    setLoading(true);
    setError("");
    let url = "https://dummyjson.com/posts";
    axios.get(url)
      .then(res => {
        setPosts(res.data.posts);
        setLoading(false);
      })
      .catch(err => {
        setError("Failed to fetch posts");
        setLoading(false);
      });
  };

  useEffect(() => {
    fetchPosts();
  }, []);

  const handleRefresh = () => {
    fetchPosts();
  };

  const handleFilter = (e) => {
    setUserId(e.target.value);
  };

  const filteredPosts = userId === "all"
    ? posts
    : posts.filter(p => p.userId === Number(userId));

  if (loading) return <div className="loader">Loading posts...</div>;
  if (error) return <div className="error">{error}</div>;

  const userIds = [...new Set(posts.map(p => p.userId))];

  return (
    <div>
      <h3>Fake API Posts</h3>
      <div className="controls">
        <button onClick={handleRefresh}>Refresh</button>
        <select value={userId} onChange={handleFilter}>
          <option value="all">All Users</option>
          {userIds.map(id => (
            <option key={id} value={id}>User {id}</option>
          ))}
        </select>
      </div>
      <div className="post-list">
        {filteredPosts.map(post => (
          <div key={post.id} className="post-card">
            <h4>{post.title}</h4>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default FakePostList;
