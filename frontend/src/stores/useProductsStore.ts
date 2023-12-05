import { create } from 'zustand';

import { Product } from '../types';

import { products } from '@/data/db-dummy.json';

interface State {
  products: Product[];
  isLoading: boolean;
  error: any;
}

interface Actions {
  fetchData: () => Promise<void>;
}

const INITIAL_STATE: State = {
  products: [],
  isLoading: false,
  error: null,
};

// let products = [];

export const useProductsStore = create<State & Actions>((set) => ({
  products: INITIAL_STATE.products,
  isLoading: INITIAL_STATE.isLoading,
  error: INITIAL_STATE.error,
  fetchData: async () => {
    try {
      set({ isLoading: true, error: null });
      // const response = await fetch('https://dummyjson.com/products');
      const data = products;
      console.log(data);

      set({ products: data, isLoading: false });
    } catch (error) {
      set({ error, isLoading: false });
    }
  },
}));
