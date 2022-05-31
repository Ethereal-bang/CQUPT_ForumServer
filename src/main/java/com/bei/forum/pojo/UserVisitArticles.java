package com.bei.forum.pojo;

public class UserVisitArticles {
    private Integer userId;

    private Integer articleId;

    private Boolean likeState;

    private Boolean commentState;

    private Boolean collectState;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Boolean getLikeState() {
        return likeState;
    }

    public void setLikeState(Boolean likeState) {
        this.likeState = likeState;
    }

    public Boolean getCommentState() {
        return commentState;
    }

    public void setCommentState(Boolean commentState) {
        this.commentState = commentState;
    }

    public Boolean getCollectState() {
        return collectState;
    }

    public void setCollectState(Boolean collectState) {
        this.collectState = collectState;
    }
}