package com.example.naviassignmentproject.model

data class RequestedTeam(
    val description: String,
    val html_url: String,
    val id: Int,
    val members_url: String,
    val name: String,
    val node_id: String,
    val parent: Any,
    val permission: String,
    val privacy: String,
    val repositories_url: String,
    val slug: String,
    val url: String
)