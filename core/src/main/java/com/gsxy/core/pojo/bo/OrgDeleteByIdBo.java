package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class OrgDeleteByIdBo implements Serializable {
        private String token;
        private Long id;
        public OrgDeleteByIdBo(){

        }

        public OrgDeleteByIdBo(String token, Long id) {
                this.token = token;
                this.id = id;
        }

        public String getToken() {
                return token;
        }

        public void setToken(String token) {
                this.token = token;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        @Override
        public String toString() {
                return "OrgDeleteByIdBo{" +
                        "token='" + token + '\'' +
                        ", id=" + id +
                        '}';
        }
}
