package com.bw.movie.bean;

import java.util.List;

public class PingBean {


    /**
     * result : [{"commentContent":"666无问问瓦打我瓦打暗色","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":426,"commentTime":1555586724000,"commentUserId":12549,"commentUserName":"lyh","greatNum":1,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"666","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":425,"commentTime":1555586378000,"commentUserId":12549,"commentUserName":"lyh","greatNum":1,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"6666","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":397,"commentTime":1555574150000,"commentUserId":12549,"commentUserName":"lyh","greatNum":1,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"瓦打瓦达瓦达瓦","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":360,"commentTime":1555559436000,"commentUserId":12549,"commentUserName":"lyh","greatNum":1,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"awasdadas ","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":350,"commentTime":1555502835000,"commentUserId":12499,"commentUserName":"冰雪","greatNum":2,"hotComment":0,"isGreat":0,"replyNum":1},{"commentContent":"","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":349,"commentTime":1555502809000,"commentUserId":12499,"commentUserName":"冰雪","greatNum":1,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"电影好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-03-12/20190312105053.thumb.700_0.jpeg","commentId":178,"commentTime":1552991926000,"commentUserId":12089,"commentUserName":"碧螺春","greatNum":5,"hotComment":0,"isGreat":0,"replyNum":3},{"commentContent":"123456","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":168,"commentTime":1552957781000,"commentUserId":12086,"commentUserName":"深海霸主皮皮虾丶","greatNum":4,"hotComment":0,"isGreat":0,"replyNum":1},{"commentContent":"1234","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":156,"commentTime":1552917511000,"commentUserId":12086,"commentUserName":"深海霸主皮皮虾丶","greatNum":5,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"小老弟","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-03-20/20190320145657.u","commentId":149,"commentTime":1552897676000,"commentUserId":12093,"commentUserName":"寂  然","greatNum":4,"hotComment":0,"isGreat":0,"replyNum":1}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commentContent : 666无问问瓦打我瓦打暗色
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/bwjy.jpg
         * commentId : 426
         * commentTime : 1555586724000
         * commentUserId : 12549
         * commentUserName : lyh
         * greatNum : 1
         * hotComment : 0
         * isGreat : 0
         * replyNum : 0
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int hotComment;
        private int isGreat;
        private int replyNum;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getHotComment() {
            return hotComment;
        }

        public void setHotComment(int hotComment) {
            this.hotComment = hotComment;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }
    }
}
