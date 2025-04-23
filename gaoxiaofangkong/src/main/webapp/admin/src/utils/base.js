const base = {
    get() {
        return {
            url : "http://localhost:8080/gaoxiaofangkong/",
            name: "gaoxiaofangkong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/gaoxiaofangkong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "疫情期间高校人员管理系统"
        } 
    }
}
export default base
