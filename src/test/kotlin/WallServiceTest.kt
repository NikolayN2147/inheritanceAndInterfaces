import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val post = Post(id = 0)
        val expected = 4
        WallService.add(post)
        val result = WallService.add(post).id

        assertEquals(expected, result)
    }

    @Test
    fun update_true() {
        val post1 = Post(id = 11)
        val post2 = Post(id = 1, text = "newText")
        WallService.add(post1)

        val result = WallService.update(post2)

        assertTrue(result)
    }

    @Test
    fun update_false() {
        val post1 = Post(id = 11)
        val post2 = Post(id = 2, text = "newText")
        WallService.add(post1)

        val result = WallService.update(post2)

        assertFalse(result)
    }

    @Test
    fun shouldAddComment() {
        val postForComment = Post(0)
        val commentForTest1 = Comment(101, "testGood")
        val expected = "testGood"

        WallService.add(postForComment)
        WallService.createComment(commentForTest1, 1)

        val result = commentForTest1.text

        assertEquals(expected, result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val commentForTest2 = Comment(102, "test")
        WallService.createComment(commentForTest2, 55)
    }

}
