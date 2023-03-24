const express = require("express");
const pool = require("../config");
const router = express.Router();

// Get comment
router.get('/:blogId/comments', async function (req, res, next) {
});

router.post('/:blogId/comments', async function (req, res, next) {
    try {
        const [rows, fields] = await pool.query(
            "INSERT INTO comments (blog_id, comment, comments.like, comment_by_id) VALUES (?, ?, ?, ?);",
            [
                req.params.blogId, req.body.comment, req.body.like, req.comment_by_id
            ]);

        return res.json({ message: "A new comment is added (ID: " + rows.insertId + ')' });
    } catch (err) {
        console.log(err)
        return next(err);
    }
});

router.put('/comments/:commentId', async function (req, res, next) {
    try {
        const [rows, fields] = await pool.query(
            "update comments set blog_id = ?, comment = ?, comments.like = ?, comment_by_id = ?, comment_date = ? where id = ?;",
            [
                req.body.blog_id, req.body.comment, req.body.like, req.body.comment_by_id, req.body.comment_date, req.params.commentId
            ]);
        return res.json({
            message: "Comment ID " + req.params.commentId + " is updated",
            comment: req.body
        });

    } catch (err) {
        console.log(err)
        return next(err);
    }
});

router.delete('/comments/:commentId', async function (req, res, next) {
    try {
        const [rows, fields] = await pool.query(
            "delete from comments where id =?;", [req.params.commentId]);
        return res.json({ message: "Comment ID " + req.params.commentId + ' is deleted.' });

    } catch (err) {
        console.log(err)
        return next(err);
    }
});


router.put('/comments/addlike/:commentId', async function (req, res, next) {
    try {
        const [rows, fields] = await pool.query("update comments set comments.like = comments.like +  1 where id = ?;", [
            req.params.commentId
        ]);

        const result = await pool.query("select * from comments where id=?;", [
            req.params.commentId
        ])

        return res.json({
            // blogId: bog[0].blog_id,
            // commentId: req.params.commentId,
            // likenum: lik[0].like + 1
            result: result[0],
        });

    } catch (err) {
        console.log(err)
        return next(err);
    }
});


exports.router = router