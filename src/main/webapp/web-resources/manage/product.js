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
        infoProductAdd: undefined,

        productIdGet: undefined,
        productUpdate: {},
        visibleProductUpdate: false,

        infoProductUpdate: undefined,
    },
    methods: {
        doProductList: function(){
            axios.get(url_productList)
            .then(response => {
                console.log("doProductList ok");
                this.productList = null;
                this.productList = response.data;
                console.log(this.productList);})
            .catch(function (error) {
                console.log(error);});
        },

        doProductAdd: function(){
            const params = new URLSearchParams();
            for (var key in this.productAdd) {
                //这里不能用this.productData.key
                params.append(key, this.productAdd[key]);
            }

            axios.post(url_productAdd, params)
            .then(response => {
                this.infoProductAdd = "添加成功";
                console.log(response);})
            .catch(function (error) {
                console.log(error);});

            for (var key in this.productAdd) {
                this.productAdd[key] = undefined;
            }
        },
        didProductAdd: function(){
            this.infoProductAdd = undefined;
        },

        doProductGet: function() {
            const params = new URLSearchParams();
            params.append('id', this.productIdGet);

            axios.post(url_productGet, params)
                .then(response => {
                this.productUpdate = response.data;
                this.infoProductUpdate = undefined;
                this.visibleProductUpdate = true;
            console.log(this.productUpdate);})
            .catch(function (error) {
                console.log(error);});
        },

        doProductUpdate: function(){
            const params = new URLSearchParams();
            for (var key in this.productUpdate) {
                params.append(key, this.productUpdate[key]);
            }

            axios.post(url_productUpdate, params)
            .then(response => {
                this.infoProductUpdate = "更改成功";
                this.productUpdate = {};
                this.visibleProductUpdate = false;
                this.productIdGet = undefined;
                console.log("doProductUpdate ok");})
            .catch(function (error) {
                console.log(error);});
        },

        doProductDelete: function() {
            const params = new URLSearchParams();
            params.append('id', this.productUpdate.id);

            axios.post(url_productDelete, params)
            .then(response => {
                this.infoProductUpdate = "删除成功";
                this.productUpdate = {};
                this.visibleProductUpdate = false;
                this.productIdGet = undefined;
            console.log(this.productUpdate);})
            .catch(function (error) {
                console.log(error);});
        },

        willProductAdd: function() {
            infoProductUpdate = undefined;
        }
    },
});