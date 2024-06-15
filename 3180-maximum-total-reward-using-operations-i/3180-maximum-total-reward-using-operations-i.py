class Solution:
    def maxTotalReward(self, rewardValues: List[int]) -> int:
        rewardValues.sort()
        candidates = set([0])
        for r in rewardValues:
            new_candidates = candidates.copy()
            for x in candidates:
                if r > x:
                    new_candidates.add(x + r)
            new_candidates.add(r)
            candidates = new_candidates
            
        return max(candidates)