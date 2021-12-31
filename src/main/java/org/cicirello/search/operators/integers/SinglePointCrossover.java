/*
 * Chips-n-Salsa: A library of parallel self-adaptive local search algorithms.
 * Copyright (C) 2002-2021 Vincent A. Cicirello
 *
 * This file is part of Chips-n-Salsa (https://chips-n-salsa.cicirello.org/).
 * 
 * Chips-n-Salsa is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Chips-n-Salsa is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
 
package org.cicirello.search.operators.integers;

import org.cicirello.search.operators.CrossoverOperator;
import org.cicirello.search.representations.IntegerVector;
import org.cicirello.math.rand.RandomIndexer;

/**
 * <p>Implementation of single point crossover, but for IntegerVectors. 
 * In a single point crossover, a random cross point is chosen
 * uniformly along the length of the parents. Both parents are cut at that
 * point. Each child gets the elements before the cross point from one parent, and the
 * elements after the cross point from the other parent. Single point crossover
 * originated for crossover of bit vectors within a genetic algorithm, but has been
 * adapted here for vectors of integers.</p>
 *
 * @param <T> The specific IntegerVector type, such as {@link IntegerVector} 
 * or {@link org.cicirello.search.representations.BoundedIntegerVector BoundedIntegerVector}.
 *
 * @author <a href=https://www.cicirello.org/ target=_top>Vincent A. Cicirello</a>, 
 * <a href=https://www.cicirello.org/ target=_top>https://www.cicirello.org/</a>
 */
public final class SinglePointCrossover<T extends IntegerVector> implements CrossoverOperator<T> {
	
	/**
	 * Constructs a single point crossover operator.
	 */
	public SinglePointCrossover() {}
	
	/**
	 * {@inheritDoc}
	 *
	 * Behavior is undefined if the IntegerVectors are of different lengths.
	 */
	@Override
	public void cross(IntegerVector c1, IntegerVector c2) {
		IntegerVector.exchange(c1, c2, 0, RandomIndexer.nextInt(c1.length()-1));
	}
	
	@Override
	public SinglePointCrossover<T> split() {
		// Doesn't maintain any state, so safe to use with multiple threads.
		// Just return this.
		return this;
	}
}
