const url_productList = "/manage/product/list";
const url_productAdd = "/manage/product/add";
const url_productUpdate = "/manage/product/update";
const url_productGet = "/manage/product/get";
const url_productDelete = "/manage/product/delete";

const product = new Vue({
    el: '#product',
    data: {
        productList: [],
        productAdd: {},
        productUpdate: {},
        productIdGet: undefined,

        visibleProductUpdate: false,
        info: {},
    },
    mounted: function() {
        //新增属性事要用 Vue set一下
        //不然在回调函数中会出现数据更新，视图不更新的问题
        Vue.set(this.info, "list", "");
        Vue.set(this.info, "add", "");
        Vue.set(this.info, "update", "");

        this.doProductList();

        //第一次不显示查询成功
        this.info.list = "";
    },
    methods: {
        doProductList: function(){
            console.log("进入 doProductList");
            console.log("发起请求，异步等待response");

            this.info.list = "查询成功";
            this.infoDelay2s("list");

            axios.get(url_productList)
            .then(response => {
                console.log("response接收成功");
                this.productList = response.data;
                console.log(response);})
            .catch(function (error) {
                console.log(error);});

            console.log("退出 doProductList");
        },

        doProductAdd: function(){
            console.log("进入 doProductAdd");
            const params = new URLSearchParams();
            for (var key in this.productAdd) {
                //这里不能用this.productData.key
                params.append(key, this.productAdd[key]);
            }

            axios.post(url_productAdd, params)
            .then(response => {
                this.info.add = "添加成功";
                this.infoDelay2s("add");
                console.log(response);})
            .catch(function (error) {
                console.log(error);});

            for (var key in this.productAdd) {
                this.productAdd[key] = undefined;
            }
            console.log("退出 doProductAdd");
        },

        doProductGet: function() {
            console.log("进入 doProductGet");

            const params = new URLSearchParams();
            params.append('id', this.productIdGet);

            axios.post(url_productGet, params)
            .then(response => {
                this.productUpdate = response.data;
                this.infoProductUpdate = undefined;
                this.visibleProductUpdate = true;
                console.log(response);})
            .catch(function (error) {
                console.log(error);});

            console.log("退出 doProductGet");
        },

        doProductUpdate: function(){
            console.log("进入 doProductUpdate");

            const params = new URLSearchParams();
            for (var key in this.productUpdate) {
                params.append(key, this.productUpdate[key]);
            }

            axios.post(url_productUpdate, params)
            .then(response => {
                this.info.update = "更改成功";
                this.infoDelay2s("update");
                this.productUpdate = {};
                this.visibleProductUpdate = false;
                this.productIdGet = undefined;
                console.log(response);})
            .catch(function (error) {
                console.log(error);});

            console.log("退出 doProductUpdate");
        },

        doProductDelete: function() {
            console.log("进入 doProductDelete");
            const params = new URLSearchParams();
            params.append('id', this.productUpdate.id);

            axios.post(url_productDelete, params)
            .then(response => {
                this.info.update = "删除成功";
                this.infoDelay2s("update");
                this.productUpdate = {};
                this.visibleProductUpdate = false;
                this.productIdGet = undefined;
                console.log(response);})
            .catch(function (error) {
                console.log(error);});

            console.log("退出 doProductDelete");
        },

        infoDelay2s: function(name) {
            setTimeout(() => {
                this.info[name] = "";
            }, 2000);
        },

    },
});