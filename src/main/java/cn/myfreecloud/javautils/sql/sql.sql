-- mysql中字符串类型的字段排序
-- 方法一：（首推）
ORDER BY '123'+0;
-- 方法二：
ORDER BY CAST('123' AS SIGNED);
-- 方法三：
ORDER BY CONVERT('123',SIGNED);