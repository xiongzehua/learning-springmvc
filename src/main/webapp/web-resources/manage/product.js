const url_productList = "/manage/product/list";
const url_productAdd = "/manage/product/add";
const url_productUpdate = "/manage/product/update";
const url_productGet = "/manage/product/get";

const product = new Vue({
    el: '#product',
    data: {
        productList: [],

        productAdd: {
            name: undefined,
            price: undefined,
            stock: undefined,
        },
        infoProductAdd: undefined,

        productUpdate: {
            id: undefined,
            name: undefined,
            price: undefined,
            stock: undefined,
        },
        infoProductUpdate: undefined,
    },
    methods: {
        doProductList: function(){
            axios.get(url_productList)
            .then(response => {
                this.productList = response.data;})
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

        doProductUpdate: function(){
            const params = new URLSearchParams();
            for (var key in this.productUpdate) {
                params.append(key, this.productUpdate[key]);
            }

            axios.post(url_productUpdate, params)
            .then(response => {
                this.infoProductUpdate = "更改成功";
                console.log(response);})
            .catch(function (error) {
                console.log(error);});

            for (var key in this.productUpdate) {
                this.productUpdate[key] = undefined;
            }
        },
        didProductUpdate: function(){
            this.infoProductAdd = undefined;
        },

        doProductGet: function(){
            const params = new URLSearchParams();
            params.append('id', this.productUpdate.id);

            axios.post(url_productGet, params)
            .then(response => {
                console.log("into doProductGet");
                this.ProductUpdate = response.data;
                console.log(response);})
            .catch(function (error) {
                console.log(error);});
        },
    },
});