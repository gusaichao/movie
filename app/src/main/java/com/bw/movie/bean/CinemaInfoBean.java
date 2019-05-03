package com.bw.movie.bean;

public class CinemaInfoBean {
    /**
     * result : {"address":"朝阳区湖景东路11号新奥购物中心B1(东A口)","businessHoursContent":"星期一 至 星期日   早09:00:00 - 晚24:00:00","commentTotal":0,"distance":0,"followCinema":1,"id":5,"logo":"http://172.17.8.100/images/movie/logo/CGVxx.jpg","name":"CGV星星影城","phone":"010-84372280 ","vehicleRoute":"乘坐913/949/484/379/628/328/419/617/751/运通110到 洼里南口下车向南走600米下沉广场即可。 乘坐83/85/510到国家体育馆下车向东走600米下沉广场即可。 地铁8号线奥林匹克公园站下车出D口对面即是。"}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * address : 朝阳区湖景东路11号新奥购物中心B1(东A口)
         * businessHoursContent : 星期一 至 星期日   早09:00:00 - 晚24:00:00
         * commentTotal : 0
         * distance : 0
         * followCinema : 1
         * id : 5
         * logo : http://172.17.8.100/images/movie/logo/CGVxx.jpg
         * name : CGV星星影城
         * phone : 010-84372280
         * vehicleRoute : 乘坐913/949/484/379/628/328/419/617/751/运通110到 洼里南口下车向南走600米下沉广场即可。 乘坐83/85/510到国家体育馆下车向东走600米下沉广场即可。 地铁8号线奥林匹克公园站下车出D口对面即是。
         */

        private String address;
        private String businessHoursContent;
        private int commentTotal;
        private int distance;
        private int followCinema;
        private int id;
        private String logo;
        private String name;
        private String phone;
        private String vehicleRoute;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getBusinessHoursContent() {
            return businessHoursContent;
        }

        public void setBusinessHoursContent(String businessHoursContent) {
            this.businessHoursContent = businessHoursContent;
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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getVehicleRoute() {
            return vehicleRoute;
        }

        public void setVehicleRoute(String vehicleRoute) {
            this.vehicleRoute = vehicleRoute;
        }
    }
}
