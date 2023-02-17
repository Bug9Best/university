var app = new Vue({
    el: '#app',
    data: {
        shopName: 'NDBest Shop',
        products: [
            {
                id: 1,
                amount: 1,
                title: "iPhone 11",
                brand: "Apple",
                price: 34900,
                totalPrice: 34900,
                is_favorite: false,
                image: 'https://images.unsplash.com/photo-1591337676887-a217a6970a8a?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80'
            },
            {
                id: 2,
                amount: 1,
                title: "Lumix GH5",
                brand: "Panasonic",
                price: 44900,
                totalPrice: 44900,
                is_favorite: false,
                image: 'https://images.unsplash.com/photo-1585459733441-9b415fed25b3?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=900&q=80'
            },
            {
                id: 3,
                amount: 1,
                title: "Vintage Model Car",
                brand: "Unknow",
                price: 990,
                totalPrice: 990,
                is_favorite: false,
                image: 'https://images.unsplash.com/photo-1581235720704-06d3acfcb36f?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80'
            },
            {
                id: 4,
                amount: 1,
                title: "Case for iPhone 11 Pro",
                brand: "Unknow",
                price: 590,
                totalPrice: 590,
                is_favorite: false,
                image: 'https://images.unsplash.com/photo-1601593346740-925612772716?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80'
            },
            {
                id: 5,
                amount: 1,
                title: "Air freshener",
                brand: "Febreze",
                price: 120,
                totalPrice: 120,
                is_favorite: false,
                image: 'https://images.unsplash.com/photo-1572635196243-4dd75fbdbd7f?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80'
            },
            {
                id: 6,
                amount: 1,
                title: "Google Home",
                brand: "Google",
                price: 3290,
                totalPrice: 3290,
                is_favorite: false,
                image: 'https://images.unsplash.com/photo-1507646227500-4d389b0012be?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80'
            },
            {
                id: 7,
                amount: 1,
                title: "VR Gaming",
                brand: "Unknow",
                price: 22490,
                totalPrice: 22490,
                is_favorite: false,
                image: 'https://images.unsplash.com/photo-1593508512255-86ab42a8e620?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=996&q=80'
            },


        ],
        cart: [],
        show_modal: false,

        addFavorite(item) {
            if (item.is_favorite) {
                if (this.cart.length > 0) {
                    let cart = this.cart.find((cart_item) => cart_item.id == item.id);
                    let products = this.products.find((product) => product.id == item.id);
                    if (cart === products) {
                        cart.price += products.totalPrice;
                        cart.amount += 1;
                    }
                    else {
                        this.cart.push(item)
                    }
                }
                else {
                    this.cart.push(item)
                }
            }
            else {
                alert("Please add to favorite first!")
            }
        },

        clearCart() {
            this.cart = []
        }
    },
})
