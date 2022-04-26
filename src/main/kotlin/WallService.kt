object WallService {
    private var posts = emptyArray<Post>()
    private var postId: Int = 1


    fun add(post: Post): Post {
        posts += post.copy(id = postId)
        postId++
        return posts.last()

    }

    fun update(post: Post): Boolean {
        for ((index, item) in posts.withIndex()) {
            if (item.id == post.id) {
                posts[index] = post.copy(id = post.id, date = post.date)
                return true
            }
        }
        return false
    }
}