// pages/book/book.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
  
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
     var that = this;
     wx.request({
       url: "http://127.0.0.1:8080/book/queryBooks",
       method: 'GET',
       data: {},
       success: function(res){
         var booksList = res.data.booksList; //booksList与后端返回的map对应的key值一样
         if (booksList == null){
           var toastText = "获取数据失败";
           wx.showToast({
             title: toastText,
             icon: '',
             duration: 2000  //出错窗口展示时间
           })
         }else{
           that.setData({
             booksList:booksList
           });
         }

       }
     })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },

  //增加图书
  addBook: function(){
    wx.navigateTo({
      url: '../operation/operation',
    })
  },

  //删除图书
  deleteBook: function(e){
    var that = this;
    wx.showModal({
      title: '提示',
      content: '确定要删除['+e.target.dataset.name +']吗?',
      success:function(sm){
        if(sm.confirm){
          wx.request({
            url: 'http://127.0.0.1:8080/book/deleteBookById',
            data: { 'id': e.target.dataset.id },
            method: 'GET',
            success: function(res){
              var result = res.data.deleteRes;
              var toastText = "删除成功!";
              if (!result) {
                toastText = "删除失败!";
              } else {
                that.data.booksList.splice(e.target.dataset.index, 1);  //删除显示
                that.setData({
                  booksList: that.data.booksList
                })
              }
              wx.showToast({
                title: toastText,
                icon: '',
                duration: 2000
              })
            }
          })
        }
      }
    })
  }
})