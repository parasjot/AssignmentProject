package com.example.naviassignmentproject.model

data class ClosedPrModelItem(
    val _links: Links,
    val active_lock_reason: String,
    val assignee: Assignee,
    val assignees: List<Assignee>,
    val author_association: String,
    val auto_merge: Any,
    val base: Base,
    val body: String,
    val closed_at: String,
    val comments_url: String,
    val commits_url: String,
    val created_at: String,
    val diff_url: String,
    val draft: Boolean,
    val head: Head,
    val html_url: String,
    val id: Int,
    val issue_url: String,
    val labels: List<Label>,
    val locked: Boolean,
    val merge_commit_sha: String,
    val merged_at: String,
    val milestone: Milestone,
    val node_id: String,
    val number: Int,
    val patch_url: String,
    val requested_reviewers: List<RequestedReviewer>,
    val requested_teams: List<RequestedTeam>,
    val review_comment_url: String,
    val review_comments_url: String,
    val state: String,
    val statuses_url: String,
    val title: String,
    val updated_at: String,
    val url: String,
    val user: UserXX
)