package items;


import java.util.Random;

/**
 * 蓄水池抽样原理：
 *     背景：在时间复杂度为O(N)，N不可预估的情况下，从N个数据中以等概率的方式随机抽取k个元素，保证每个元素被抽取的概率为k/N
 *     做法：先选中第1到k个元素，作为被选中的元素。然后依次对第k+1至第N个元素做如下操作：每个元素都有k/x的概率被选中，然后等概率的(1/k)替换
 *          掉被选中的元素。其中x是元素的序号(x从1开始，x即为遍历到该元素时，该节点及前面节点的总数为x)。最后剩下的k个元素即为待选的k个元素。
 *     证明：采用用归纳法证明：假设当前是i+1, 按照规定，i+1这个元素被选中的概率是k/i+1，也即第i+1这个元素在蓄水池中出现的概率是k/i+1，此时考
 *          虑前i个元素，如果前i个元素出现在蓄水池中的概率都是k/i+1的话，说明算法正确。
 *
 *          对这个问题可以用归纳法来证明：k < i <=N
 *          1. 当i=k+1的时候，蓄水池的容量为k，第k+1个元素被选择的概率明显为k/(k+1), 此时前k个元素出现在蓄水池的概率为 k/(k+1), 很明显结
 *             论成立。
 *          2. 假设当 j=i 的时候结论成立，此时以 k/i 的概率来选择第i个元素，前i-1个元素出现在蓄水池的概率都为k/i。
 *
 *          证明当j=i+1的情况：即需要证明当以 k/i+1 的概率来选择第i+1个元素的时候，此时任一前i个元素出现在蓄水池的概率都为k/(i+1).
 *          前i个元素出现在蓄水池的概率有2部分组成：
 *              a. 在第i+1次选择前得出现在蓄水池中
 *              b. 得保证第i+1次选择的时候不被替换掉
 *          1. 由2知道在第i+1次选择前，任一前i个元素出现在蓄水池的概率都为k/i
 *          2. 考虑被替换的概率：首先要被替换得第 i+1 个元素被选中(不然不用替换了)概率为 k/i+1，其次是因为随机替换的池子中k个元素中任意一个，
 *             所以不幸被替换的概率是 1/k，故前i个元素(池中元素)中任一被替换的概率 = k/(i+1) * 1/k = 1/i+1。则(池中元素中)没有被替换的概
 *             率为: 1 - 1/(i+1) = i/i+1
 *          综合1, 2通过乘法规则：得到前i个元素出现在蓄水池的概率为 k/i * i/(i+1) = k/i+1
 *      故证明成立。
 *
 * @author hechuan
 */
public class LinkedListRandomNode_382 {

    private ListNode head;
    private Random random;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode_382(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode curr = head.next, res = head;
        int count = 1;
        while (curr != null) {
            // use proportion 1/i to select node. count starts from 0, so current node count is count+1.
            if (random.nextInt(count+1) == count) { res = curr; }
            count++;
            curr = curr.next;
        }

        return res.val;
    }
}
