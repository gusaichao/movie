package com.bw.movie.bean;

import java.util.List;

public class CinemaPageListBean {


    /**
     * result : [{"address":"朝阳区建国路93号万达广场三层","commentTotal":0,"distance":0,"followCinema":0,"id":6,"logo":"http://172.17.8.100/images/movie/logo/wd.jpg","name":"北京CBD万达广场店"},{"address":"朝阳区湖景东路11号新奥购物中心B1(东A口)","commentTotal":0,"distance":0,"followCinema":0,"id":5,"logo":"http://172.17.8.100/images/movie/logo/CGVxx.jpg","name":"CGV星星影城"},{"address":"西城区前门大街大栅栏街36号","commentTotal":0,"distance":0,"followCinema":0,"id":2,"logo":"http://172.17.8.100/images/movie/logo/dgl.jpg","name":"大观楼电影院"},{"address":"东城区滨河路乙1号雍和航星园74-76号楼","commentTotal":0,"distance":0,"followCinema":0,"id":1,"logo":"http://172.17.8.100/images/movie/logo/qcgx.jpg","name":"青春光线电影院"}]
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
         * address : 朝阳区建国路93号万达广场三层
         * commentTotal : 0
         * distance : 0
         * followCinema : 0
         * id : 6
         * logo : http://172.17.8.100/images/movie/logo/wd.jpg
         * name : 北京CBD万达广场店
         */

        private String address;
        private int commentTotal;
        private int distance;
        private int followCinema;
        private int id;
        private String logo;
        private String name;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getCommentTotal() {
            return commentTotal;
        }

        public void setCommentTotal(int commentTotal) {
            this.commentTotal = commentTotal;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getFollowCinema() {
            return followCinema;
        }

        public void setFollowCinema(int followCinema) {
            this.followCinema = followCinema;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
