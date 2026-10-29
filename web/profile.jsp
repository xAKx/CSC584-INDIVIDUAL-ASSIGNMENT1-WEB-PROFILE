<%-- 
    Document   : profile
    Created on : Oct 29, 2026, 3:39:28 PM
    Updated on : 0ct 29, 8:38 PM
    Author     : akmal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    // Display entered values as text instead of allowing them to become HTML.
    private String escapeHtml(Object value) {
        if (value == null) {
            return "";
        }
        return value.toString().trim().replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
%>
<%
    String error = (String) request.getAttribute("error");
    if (error == null) {
        response.sendRedirect("index.html");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Profile - Mintfolio</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>
    <a class="skip-link" href="#profile-content">Skip to profile</a>
    <header class="site-header">
        <a class="wordmark" href="index.html">mintfolio<span class="brand-dot">.</span></a>
        <span class="header-note">YOUR LITTLE CORNER OF THE WEB</span>
    </header>
    <main id="profile-content" class="layout">
        <% if (!error.equals("")) { %>
            <section class="intro">
                <p class="eyebrow">A LITTLE CHECK FIRST</p>
                <h1 class="profile-title">Almost<br><em>there.</em></h1>
            </section>
            <section class="form-card">
                <h2>Please check your details.</h2>
                <p><%= escapeHtml(error) %></p>
                <p>Use your browser's Back button to return to your entries, or start a new form below.</p>
                <a class="profile-back" href="index.html">Start a new form</a>
            </section>
        <% } else { %>
            <section class="intro">
                <p class="eyebrow">A LITTLE SNAPSHOT OF YOU</p>
                <h1 class="profile-title">Hello,<br><em><%= escapeHtml(request.getAttribute("name")) %>.</em></h1>
                <p class="intro-copy">Your story, in your own words. Here is your little corner of the web.</p>
            </section>
            <section class="form-card profile-card">
                <p class="section-number">02 / YOUR PROFILE</p>
                <h2>Nice to meet you.</h2>
                <dl class="profile-details">
                    <div class="profile-detail profile-detail-wide">
                        <dt>Full name</dt>
                        <dd><%= escapeHtml(request.getAttribute("name")) %></dd>
                    </div>
                    <div class="profile-detail">
                        <dt>Student ID</dt>
                        <dd><%= escapeHtml(request.getAttribute("studentId")) %></dd>
                    </div>
                    <div class="profile-detail">
                        <dt>Programme</dt>
                        <dd><%= escapeHtml(request.getAttribute("programme")) %></dd>
                    </div>
                    <div class="profile-detail profile-detail-wide">
                        <dt>Email address</dt>
                        <dd><%= escapeHtml(request.getAttribute("email")) %></dd>
                    </div>
                    <div class="profile-detail profile-detail-wide">
                        <dt>Hobbies</dt>
                        <dd><%= escapeHtml(request.getAttribute("hobbies")) %></dd>
                    </div>
                    <div class="profile-detail profile-detail-wide">
                        <dt>Short self-introduction</dt>
                        <dd><%= escapeHtml(request.getAttribute("introduction")) %></dd>
                    </div>
                </dl>
                <div class="form-actions profile-actions">
                    <p>This profile is displayed only.<br>Your details are not saved.</p>
                    <a class="profile-back" href="index.html">Create another profile</a>
                </div>
            </section>
        <% } %>
    </main>
    <footer class="site-footer"><p>Made with a little curiosity and a lot of mint.</p></footer>
</body>
</html>

