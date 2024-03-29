class Solution:
    def minimumMoves(self, grid: list[list[int]]) -> int:
        debug = False
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        result, n = 0, len(grid)

        walked = {(0, 0, 0, 1)}
        # [0,0][0,1]
        # self.show(grid, 0, 0, 0, 1)
        # self.show(grid, 1, 1,1, 2)
        # 旋转表 顺时针
        target = (n - 1, n - 2, n - 1, n - 1)
        # self.show(matrix, x1, y1, x2, y2)

        # print(x1, y1, x2, y2)
        # print(self.cov_dir(x1, y1, x2, y2, True))
        # x1, x1, x2, y2 = self.cov_dir(x1, y1, x2, y2, True)
        # x1, y1, x2, y2 = self.cov_dir(x1, y1, x2, y2, False)
        # x1, y1, x2, y2 = self.cov_dir(x2, y2, x1, y1, False)
        # x1, y1, x2, y2 = self.cov_dir(x2, y2, x1, y1, True)
        now_nodes = {(0, 0, 0, 1)}
        if debug:
            node_Map = {(0, 0, 0, 1): None}
        while len(now_nodes) > 0:
            next_nodes = set()
            for current_node in now_nodes:
                for next_node in self.can_cov(grid, *current_node):
                    if next_node not in walked:
                        if debug:
                            node_Map[next_node] = current_node
                        # 终止条件
                        if next_node == target:
                            if debug:
                                idx = 0
                                while node_Map[next_node] is not None:
                                    print("\n", idx, ":")
                                    print(next_node)
                                    self.show(matrix, *next_node)
                                    next_node = node_Map[next_node]
                                    idx += 1
                            return result + 1
                        next_nodes.add(next_node)
            walked = walked.union(next_nodes)
            now_nodes.clear()
            now_nodes = now_nodes.union(next_nodes)
            result += 1
            # now_nodes, result = now_nodes, result + 1
        # next = self.can_cov(matrix, 0, 0, 0, 1)

        #
        #
        # print(next)
        # self.show(matrix, x1, y1, x2, y2)
        return -1

    # def cov(self, x1: int, y1: int, x2: int, y2: int, dir: bool) -> (int, int, int, int):
    #     if x1 >x2 or x1
    def can_cov(self, matrix: list[list], x1: int, y1: int, x2: int, y2: int) -> set:
        # print(x1, y1, x2, y2)
        result = set()
        # 横向
        if x1 == x2:
            # 右移
            if y2 + 1 < len(matrix) and matrix[x1][y2 + 1] == 0:
                result.add((x1, y1 + 1, x2, y2 + 1))
            # # 左移
            # if y1 > 0:
            #     result.add((x1, y1 - 1, x2, y2 - 1))
            # 上方有空
            if x1 > 0 and matrix[x1 - 1][y1] == 0 and matrix[x2 - 1][y2] == 0:
                # 上移
                result.add((x1 - 1, y1, x2 - 1, y2))
                # # 顺时针旋转，右边为尾部
                # result.add(self.cov_dir(x2, y2, x1, y1, True))
                # # 逆时针旋转，左边为尾部
                # result.add(self.cov_dir(x1, y1, x2, y2, False))
            # 下方有空
            if x1 + 1 < len(matrix) and matrix[x1 + 1][y1] == 0 and matrix[x2 + 1][y2] == 0:
                # 下移
                result.add((x1 + 1, y1, x2 + 1, y2))
                # 顺时针旋转，左边为尾部
                result.add(self.cov_dir(x1, y1, x2, y2, True))
                # # 逆时针旋转，右边为尾部
                # result.add(self.cov_dir(x2, y2, x1, y1, False))
        # 纵向
        else:
            # # 上移
            # if x1 > 0 and matrix[x1 - 1][y1] == 0:
            #     result.add((x1 - 1, y1, x2 - 1, y2))
            # 下移
            if x2 + 1 < len(matrix) and matrix[x2 + 1][y2] == 0:
                result.add((x1 + 1, y1, x2 + 1, y2))
            # 右边有空
            if y1 + 1 < len(matrix) and matrix[x1][y1 + 1] == 0 and matrix[x2][y2 + 1] == 0:
                # 右移
                result.add((x1, y1 + 1, x2, y2 + 1))
                # # 顺时针旋转，下边为尾部
                # result.add(self.cov_dir(x2, y2, x1, y1, True))
                # 逆时针旋转，上边为尾部
                result.add(self.cov_dir(x1, y1, x2, y2, False))
            # # 左边有空
            # if y1 > 0 and matrix[x1][y1 - 1] == 0 and matrix[x2][y2 - 1] == 0:
            #     # 左移
            #     # result.add((x1, y1-1, x2 , y2-1))
            #     # # 顺时针旋转，上边为尾部
            #     # result.add(self.cov_dir(x1, y1, x2, y2, True))
            #     # # 逆时针旋转，右边为尾部
            #     # result.add(self.cov_dir(x2, y2, x1, y1, False))

        return result

    def cov_dir(self, x1: int, y1: int, x2: int, y2: int, dir: bool) -> (int, int, int, int):
        x1, y1, x2, y2 = self._cov_dir(x1, y1, x2, y2, dir)
        if x1 > x2 or y1 > y2:
            return x2, y2, x1, y1
        else:
            return x1, y1, x2, y2

    def _cov_dir(self, x1: int, y1: int, x2: int, y2: int, dir: bool) -> (int, int, int, int):
        # print(x1, y1, x2, y2)
        if dir:
            # 横向
            if x1 == x2:
                if y1 < y2:
                    return x1, y1, x1 + 1, y1
                else:
                    return x1, y1, x1 - 1, y1
            else:
                if x1 > x2:
                    return x1, y1, x1, y1 - 1
                else:
                    return x1, y1, x1, y1 + 1
        else:
            # 横向
            if x1 == x2:
                if y1 > y2:
                    return x1, y1, x1 + 1, y1
                else:
                    return x1, y1, x1 - 1, y1
            else:
                if x1 < x2:
                    return x1, y1, x1, y1 + 1
                else:
                    return x1, y1, x1, y1 + 1

    def show(self, matrix: list[list[int]], x1, y1, x2, y2):
        print(x1, y1, x2, y2)
        matrix[x1][y1] = 8
        matrix[x2][y2] = 8
        for arr in matrix:
            print(arr)
        matrix[x1][y1] = 0
        matrix[x2][y2] = 0


if __name__ == '__main__':
    sl = Solution()
    # matrix = [[0, 0, 0, 0, 0, 1],
    #           [1, 1, 0, 0, 1, 0],
    #           [0, 0, 0, 0, 1, 1],
    #           [0, 0, 1, 0, 1, 0],
    #           [0, 1, 1, 0, 0, 0],
    #           [0, 1, 1, 0, 0, 0]]
    #
    # # print(sl.cov(0, 0, 0, 1, True))
    # # print(sl.cov(0, 0, 0, 1, False))
    # print(sl.minimumMoves(matrix))
    # matrix = [[0, 0, 1, 1, 1, 1],
    #           [0, 0, 0, 0, 1, 1],
    #           [1, 1, 0, 0, 0, 1],
    #           [1, 1, 1, 0, 0, 1],
    #           [1, 1, 1, 0, 0, 1],
    #           [1, 1, 1, 0, 0, 0]]
    #
    # # # matrix = [[0, 0, 0, 0, 0, 0],
    # # #           [0, 0, 0, 0, 0, 0],
    # # #           [0, 0, 0, 0, 0, 0],
    # # #           [0, 0, 0, 0, 0, 0],
    # # #           [0, 0, 0, 0, 0, 0],
    # # #           [0, 0, 0, 0, 0, 0], ]
    # print(sl.minimumMoves(matrix))

    matrix = [[0, 0, 0, 0, 0, 0, 0, 0, 0, 1], [0, 1, 0, 0, 0, 0, 0, 1, 0, 1], [1, 0, 0, 1, 0, 0, 1, 0, 1, 0],
              [0, 0, 0, 1, 0, 1, 0, 1, 0, 0], [0, 0, 0, 0, 1, 0, 0, 0, 0, 1], [0, 0, 1, 0, 0, 0, 0, 0, 0, 0],
              [1, 0, 0, 1, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
              [1, 1, 0, 0, 0, 0, 0, 0, 0, 0]]
    print(sl.minimumMoves(matrix))
    # matrix =[[0,0,0,0,0,0,0,0,0,1],[1,1,1,0,0,0,0,0,0,0],[0,0,0,0,0,0,1,0,0,0],[0,0,0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,1,0,0],[0,0,1,0,1,1,1,0,0,0],[0,0,1,0,0,0,1,0,1,0],[0,0,0,0,0,0,0,0,0,0],[0,1,0,0,0,0,1,0,0,0],[0,0,0,0,0,0,1,0,0,0]]
    # print(sl.minimumMoves(matrix))
