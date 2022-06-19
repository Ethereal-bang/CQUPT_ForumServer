# CQUPT_ForumServer

# 数据库
[!ER](https://cdn.nlark.com/yuque/0/2022/jpeg/2617721/1655608309314-b83e4eca-39d7-4658-b931-382426299078.jpeg?x-oss-process=image%2Fresize%2Cw_1280%2Climit_0)

# /user 用户

## 发送验证码 /verify

+ Param：email

```json
{"flag":true,"msg":"邮件发送成功，请查看验证码","data":{}}
{"flag":false,"msg":"邮件发送失败","data":{}}
```



## 登录 /login

+ Param：email，code

```json
{"flag":true,"msg":"登录成功","data":{
  "user":{"id":4,"email":"939847757@qq.com","name":"大黄","avatarLink":"http://photo.chaoxing.com/photo_80.jpg","avatarOrder":1
}}
{"flag":false,"msg":"邮箱验证出错，请重试","data":{}}
{"flag":false,"msg":"账号创建出错","data":{}}
```



## 返回个人信息 /{email}/info

```json
{"flag":true,"msg":"查询成功","data":{"user":{"id":4,"email":"939847757@qq.com","name":null,"avatarLink":"http://photo.chaoxing.com/photo_80.jpg","avatarOrder":1}}}
```



## 返回个人信息 /info

+ Param: name

```json
{"flag":true,"msg":"查询成功","data":{"user":{"id":4,"email":"939847757@qq.com","name":"什么时候去北欧","avatarLink":"https://himg.bdimg.com/sys/portraitn/item/public.1.18651f64.8tN1Hz89zni44XOizQBKoA","avatarOrder":3}}}
```



## 修改资料 /{email}/set

+ Param:  name, img

```json
{"flag":true,"msg":"修改成功","data":{"user":{"id":3,"email":"1300850146@qq.com","name":"烁","avatarLink":"http://photo.chaoxing.com/photo_80.jpg","avatarOrder":1}}}
{"flag":false,"msg":"修改出错","data":{}}
```



# /article 文章

## 获得文章 /{id}

```json
# notices类型
{"flag":true,"msg":"查询成功",
 "data":{
   "articles":{
     "id":1,
     "type":"notices",
     "title":"测试",
     "content":"测试内容",
     "createTime":"2022-06-01 09:05:58",
     "visit":0,
     "like":0,
     "collection":0}}}
# posts类型
{"flag":true,"msg":"查询成功",
 "data":{
   "articles":{
     "id":2,
     "type":"posts",
     "title":"测试贴",
     "createTime":"2022-06-01T17:19:20.000+00:00",
     "updateTime":null,
     "like":0,
     "visit":0,
     "collection":0,
     "comment":0}}}
```



## 我的收藏 /article/oneCollected

+ Param: id

```json
{
    "flag": true,
    "msg": "查询成功",
    "data": {
        "list": [
            {
                "id": 3,
                "type": "posts",
                "title": "期末啦",
                "author": "大黄去北欧",
                "content": "考试月来啦，终于快放假啦",
                "area": "share",
                "state": "great",
                "createTime": "2022-06-08 04:24:30",
                "updateTime": "",
                "like": 0,
                "visit": 0,
                "collection": 0,
                "comment": 2
            },
            {
                "id": 1,
                "type": "notices",
                "title": "测试",
                "content": "测试内容",
                "area": "game",
                "createTime": "2022-06-01 09:05:58",
                "visit": 0,
                "like": 0,
                "collection": 0
            }
        ]
    }
}
```



## /article/notice

### 返回所有公告 /showAll

```json
{"flag":true,"msg":"查询成功","data":{"game":[{"id":1,"type":"notices","title":"测试","content":"测试内容","area":"game","state":"normal","createTime":"2022-06-01 09:05:58","visit":0,"like":null,"collection":null}],"notice":[]}}
```



## /article/post

### 返回所有帖子 /showAll

```json
{"flag":true,"msg":"查询成功","data":{"tech":[],"study":[],"work":[],"share":[{"id":0,"type":"posts","title":"期末啦","author":"大黄去北欧","content":"考试月来啦，终于快放假啦","area":"share","state":"great","createTime":"2022-06-08 04:24:30","updateTime":"","like":0,"visit":0,"collection":0,"comment":0}]}}
```



### 我的发布 /onePosted

+ Param: author(String)

```json
{"flag":true,"msg":"查询成功",
 "data":{
   "list":[
     {
        area: "share"
        author: "大黄去北欧"
        collection: 0
        comment: 2
        content: "考试月来啦，终于快放假啦"
        createTime: "2022-06-08 04:24:30"
        id: 3
        like: 0
        state: "great"
        title: "期末啦"
        type: "posts"
        updateTime: ""
        visit: 0   
     }
   ]
```



### 评论最多的前十条 /mostComment

```json
{"flag":true,"msg":"查询成功","data":{"list":[{"id":3,"type":"posts","title":"期末啦","author":"大黄去北欧","content":"考试月来啦，终于快放假啦","area":"share","state":"great","createTime":"2022-06-08 04:24:30","updateTime":"","like":null,"visit":0,"collection":null,"comment":null},{"id":2,"type":"posts","title":"测试贴","author":"要秃头的烁子","content":"测试贴内容","area":"share","state":null,"createTime":"2022-06-02 01:19:20","updateTime":"","like":null,"visit":0,"collection":null,"comment":null}]}}
```



### 最新回复	/recentComment

```json
{"flag":true,"msg":"查询成功","data":{"list":[{"id":2,"type":"posts","title":"测试贴","author":"要秃头的烁子","content":"测试贴内容","area":"share","state":null,"createTime":"2022-06-02 01:19:20","updateTime":"","like":null,"visit":0,"collection":null,"comment":null},{"id":3,"type":"posts","title":"期末啦","author":"大黄去北欧","content":"考试月来啦，终于快放假啦","area":"share","state":"great","createTime":"2022-06-08 04:24:30","updateTime":"","like":null,"visit":0,"collection":null,"comment":null}]}}
```



# /avatar 头像

## 返回所有头像 /showAll

```json
{"flag":true,"msg":"查询成功",
 "data":{
   "list":["http://photo.chaoxing.com/photo_80.jpg","http://photo.chaoxing.com/photo_80.jpg","https://himg.bdimg.com/sys/portraitn/item/public.1.18651f64.8tN1Hz89zni44XOizQBKoA"]}}
```



## 获得头像 /{order}

```json
{"flag":true,"msg":"查询成功","data":{"link":"http://photo.chaoxing.com/photo_80.jpg"}}
```



# /news 消息

## 获取评论列表 /{id}/showComment

```json
{"flag":true,"msg":"查询成功","data":{"list":[{
    "carrier_id": 3,
    "receiver": 3,
    "create_time": "2022-06-08T21:34:20",
    "sender": 4,
    "name": "大黄去北欧",
    "link": "https://himg.bdimg.com/sys/portraitn/item/public.1.18651f64.8tN1Hz89zni44XOizQBKoA",
    "_id": 1,
    "state": false,
    "type": "comment",
    "content": "就是就是",
    "avatar_order": 3
}]}}
```



## 点赞/收藏/评论/回复 POST /send

+ Body: 

    | sender   | receiver | carrierId    | type                       | content |
    | -------- | -------- | ------------ | -------------------------- | ------- |
    | 发送者id | 接收者id | 文章/消息 id | like/comment/collect/reply | 内容    |

    

## 我的消息 /received

+ Param: receiver

```json
{"flag":true,"msg":"查询成功","data":{"list":[{"carrier_id":3,"area":"share","create_time":"2022-06-11T12:25:16","name":"大黄去北欧","type":"comment","content":"咋没人~"}]}}
```



## 未读消息数 /noRead

+ Param: receiver

```json
{"flag":true,"msg":"查询成功","data":{"count":0}}
```



# /report 举报

## /add 发送举报

```json
{"flag":true,"msg":"举报已发出，正在受理","data":{}}
{"flag":false,"msg":"举报发送失败，请重试","data":{}}
```



## /del 删除举报

```json
{"flag":true,"msg":"删除成功","data":{}}
{"flag":false,"msg":"删除失败","data":{}}
```



# /root 管理员

## /data 返回待可视化数据

```json
{"flag":true,"msg":"查询成功","data":{"data":{"newPosts":0,"allUsers":3,"comment":3}}}
```



## /addArea 创建区块

+ Param: name, url, words

```json
{"flag":true,"msg":"区块创建成功","data":{}}{"flag":false,"msg":"区块创建失败","data":{}}
```



## /area 展示区块

```json
{"flag":true,"msg":"查询成功","data":{"list":[{"id":1,"name":"日常分享","url":"share","words":"尽情分享你的乐趣生活~"},{"id":3,"name":"学业互助","url":"study","words":"学业互助，成就更好的我们~"},{"id":4,"name":"技术交流","url":"technology","words":"重邮技术栈，非同一般！"},{"id":5,"name":"求职讨论","url":"work","words":"我们都能找到满意的工作~"}]}}
```



##  /setArea 修改区块

```json
{"flag":true,"msg":"区块修改成功","data":{}}{"flag":false,"msg":"区块修改失败","data":{}}
```



## /delArea 删除区块

+ Param: id

```json
{"flag":true,"msg":"区块删除成功","data":{}}{"flag":false,"msg":"区块删除失败","data":{}}
```



## /addNotice POST 发布公告

+ Body:

| title | content | area               |
| ----- | ------- | ------------------ |
| 标题  | 正文    | "notice" \| "game" |



## /user 用户列表

```json
{"flag":true,"msg":"查询成功","data":{"amount":2,"list":[{"id":3,"email":"1300850146@qq.com","name":"要秃头的烁子","avatarLink":null,"avatarOrder":null},{"id":4,"email":"939847757@qq.com","name":"大黄去北欧","avatarLink":null,"avatarOrder":null}]}}
```



## /report 举报列表

```json
{"flag":true,"msg":"查询成功","data":{"list":[{"id":4,"reporter":4,"comment":8,"post":0,"reported":"大黄去北欧","type":"comment","content":"好水"},{"id":5,"reporter":4,"comment":0,"post":2,"reported":"要秃头的烁子","type":"post","content":"测试贴内容"}]}}
```

